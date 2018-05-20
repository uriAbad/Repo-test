package uriabad.com.startapp.network.services

import uriabad.com.startapp.network.ApiConstants
import uriabad.com.startapp.network.ApiEndpoints
import uriabad.com.startapp.network.responses.LoginResponse
import uriabad.com.startapp.network.responses.RegisterResponse
import retrofit2.Call
import retrofit2.http.POST
import retrofit2.http.Query
import retrofit2.http.QueryMap

interface AuthenticationService {

    @POST(ApiEndpoints.LOGIN)
    fun login(@QueryMap params: Map<String, String>) : Call<LoginResponse>

    @POST(ApiEndpoints.USER)
    fun register(@Query(ApiConstants.EMAIL) email: String,
                 @Query(ApiConstants.PASSWORD) password: String,
                 @Query(ApiConstants.CONFIRM_PASSWORD) confirm: String,
                 @Query(ApiConstants.NEWSLETTER) newsletter: Boolean,
                 @Query(ApiConstants.TRIAL) trial: Boolean)
            : Call<RegisterResponse>
}