package uriabad.com.startapp

import uriabad.com.startapp.model.exceptions.NetworkException
import com.google.gson.Gson
import com.google.gson.JsonElement
import com.google.gson.reflect.TypeToken
import retrofit2.Response

val TAG_DATA = "Data"

inline fun<reified T> Response<JsonElement>.parseJsonResponse(rootTag: String,
                                                              jsonObject : String = ""): T {
    val gson = Gson()
    val type = object : TypeToken<T>() {}.type
    val jsonResponse = this.body()!!.asJsonObject.get(rootTag)
    if (jsonObject.isNotEmpty()) {
        val parsedResponse: T = gson.fromJson(jsonResponse.asJsonObject.get(jsonObject), type)
        return parsedResponse
    } else {
        val parsedResponse: T = gson.fromJson(jsonResponse, type)
        return parsedResponse
    }
}
inline fun<reified T> Response<JsonElement>.parseResponse(rootTag: String = TAG_DATA,
                                                          jsonObject: String = ""): Result<T, Exception> {
    if (this.isSuccessful) {
        return Result.of {
            this.parseJsonResponse<T>(rootTag, jsonObject)
        }
    } else {
        return Result.Failure(getExceptionFromHttpErrorCode(this.code()))
    }
}
fun getExceptionFromHttpErrorCode(code: Int): Exception {
    when (code) {
        401 -> return NetworkException.UnauthorizedException()
        500 -> return NetworkException.ServerException()
        else -> return Exception()
    }
}