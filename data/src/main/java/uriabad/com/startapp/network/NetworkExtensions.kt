package uriabad.com.startapp.network

import uriabad.com.startapp.model.exceptions.NetworkException
import uriabad.com.startapp.network.responses.CommonErrorResponse
import com.google.gson.Gson
import okhttp3.ResponseBody
import retrofit2.Response
import java.util.concurrent.TimeUnit

private val DATE_FORMAT_HMS = "%2d:%02d:%02d"
private val DATE_FORMAT_MS = "%02d:%02d"

inline fun <reified T: Any> Response<T>.getErrorException() : Exception {
    return when (this.code()) {
        401, 403 -> NetworkException.UnauthorizedException()
        422 -> NetworkException.UnprocessableEntityException(this.errorBody()!!.extractErrorMessage())
        500 -> NetworkException.ServerException()
        else -> Exception()
    }
}

fun ResponseBody.extractErrorMessage() : String? {
    try {
        val errorResponse = Gson().fromJson(this.string(), CommonErrorResponse::class.java)
        if (errorResponse.error.messages.isNotEmpty())
            return errorResponse.error.messages[0]
    } catch (e: Exception) { return null }
    return null
}

fun ResponseBody.extractErrorCode() : String? {
    try {
        val errorResponse = Gson().fromJson(this.string(), CommonErrorResponse::class.java)
        if (errorResponse.error.codes.isNotEmpty())
            return errorResponse.error.codes[0]
    } catch (e: Exception) { return null }
    return null
}

fun String?.safe() = this ?: ""
fun Int?.safe() = this ?: 0
fun Double?.safe() = this ?: 0.0
fun Long?.safe() = this ?: 0L
fun Boolean?.safe() = this ?: false

fun List<Any>?.safe() = this ?: listOf()
fun Map<Any, Any>?.safe() = this ?: mapOf()

fun String.appendHttpsPrefix(): String {
    return if (!startsWith(ApiConstants.HTTP)) ApiConstants.HTTPS.plus(this) else this
}

fun String.toCompoundDuration(): String {
    return if (isNotEmpty()) {
        val duration = this.toLong()
        val seconds = TimeUnit.SECONDS.toSeconds(duration).rem(60)
        val minutes = TimeUnit.SECONDS.toMinutes(duration).rem(60)
        val hours = TimeUnit.SECONDS.toHours(duration)
        return if (hours > 0) String.format(DATE_FORMAT_HMS, hours, minutes, seconds)
        else String.format(DATE_FORMAT_MS, minutes, seconds)
    } else "Not set"
}

fun Long.toCompoundDuration(): String {
    val seconds = TimeUnit.SECONDS.toSeconds(this).rem(60)
    val minutes = TimeUnit.SECONDS.toMinutes(this).rem(60)
    val hours = TimeUnit.SECONDS.toHours(this)
    return if (hours > 0) String.format(DATE_FORMAT_HMS, hours, minutes, seconds)
    else String.format(DATE_FORMAT_MS, minutes, seconds)
}