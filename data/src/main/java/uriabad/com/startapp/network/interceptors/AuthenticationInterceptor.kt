package uriabad.com.startapp.network.interceptors

import uriabad.com.startapp.SessionData
import uriabad.com.startapp.StoreConstants
import uriabad.com.startapp.model.exceptions.NetworkException
import uriabad.com.startapp.network.ConnectionChecker
import uriabad.com.startapp.repository.PreferencesRepository
import com.google.gson.Gson
import okhttp3.Interceptor
import okhttp3.Response
import java.io.IOException
import javax.inject.Inject

class AuthenticationInterceptor @Inject constructor(private val connectionChecker: ConnectionChecker,
                                                    val preferencesRepository: PreferencesRepository) : Interceptor {

    companion object {
        val APP_AUTHORIZATION = "Application-Authorization"
        val PRIME_STREAM = "prime_stream"
        val AUTHORIZATION = "Authorization"
        val BEARER = "Bearer "
    }

    private var userKey = ""

    @Throws(IOException::class)
    override fun intercept(chain: Interceptor.Chain): Response {
        val builder = chain.request().newBuilder()
        if (connectionChecker.thereIsConnectivity()) {
            refreshUserKey()
            builder.addHeader(APP_AUTHORIZATION, PRIME_STREAM)
            if (userKey.isNotBlank()) builder.addHeader(AUTHORIZATION, userKey)
            return chain.proceed(builder.build())
        }
        throw NetworkException.NoInternetConnection()
    }

    private fun refreshUserKey() {
        val rawData = preferencesRepository.get(StoreConstants.SESSION_DATA)
        rawData.success {
            val sessionData = Gson().fromJson(it, SessionData::class.java)
            if (sessionData.token.isNotBlank()) userKey = BEARER + sessionData.token
        }
        rawData.failure {
            userKey = ""
        }
    }
}