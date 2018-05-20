package uriabad.com.startapp.network.interceptors

import okhttp3.Interceptor
import okhttp3.Response
import uriabad.com.startapp.model.exceptions.NetworkException
import uriabad.com.startapp.network.ApiEndpoints
import uriabad.com.startapp.network.ConnectionChecker
import java.io.IOException
import javax.inject.Inject

class AuthenticationInterceptor @Inject constructor(private val connectionChecker: ConnectionChecker) : Interceptor {

    companion object {
        val AUTHORIZATION = "token"
    }

    @Throws(IOException::class)
    override fun intercept(chain: Interceptor.Chain): Response {
        val builder = chain.request().newBuilder()
        if (connectionChecker.thereIsConnectivity()) {
            builder.addHeader(AUTHORIZATION, ApiEndpoints.PERSONAL_TOKEN)
            return chain.proceed(builder.build())
        }
        throw NetworkException.NoInternetConnection()
    }
}