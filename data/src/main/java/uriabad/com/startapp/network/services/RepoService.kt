package uriabad.com.startapp.network.services

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.QueryMap
import uriabad.com.startapp.network.ApiEndpoints.Companion.REPOSITORIES
import uriabad.com.startapp.repository.entities.RepoDataEntity

interface RepoService {

    @GET(REPOSITORIES)
    fun getRepos(@QueryMap params: Map<String, String>) : Call<Collection<RepoDataEntity>>

}

