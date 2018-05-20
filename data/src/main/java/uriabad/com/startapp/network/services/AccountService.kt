package uriabad.com.startapp.network.services

import uriabad.com.startapp.network.ApiEndpoints
import uriabad.com.startapp.network.responses.GetAccountResponse
import uriabad.com.startapp.network.responses.UpdateAccountResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.PATCH
import retrofit2.http.QueryMap

interface AccountService {
    @GET(ApiEndpoints.USER)
    fun getAccount() : Call<GetAccountResponse>

    @PATCH(ApiEndpoints.USER)
    fun updateAccount(@QueryMap params: Map<String, String>) : Call<UpdateAccountResponse>
}