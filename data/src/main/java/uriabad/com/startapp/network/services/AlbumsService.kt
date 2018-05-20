package uriabad.com.startapp.network.services

import uriabad.com.startapp.network.ApiEndpoints
import uriabad.com.startapp.network.responses.GetAlbumDetailResponse
import uriabad.com.startapp.network.responses.GetAlbumsResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.http.QueryMap

interface AlbumsService {
    @GET(ApiEndpoints.ALBUMS)
    fun getAlbums(@QueryMap params: Map<String, String>) : Call<GetAlbumsResponse>

    @GET(ApiEndpoints.ALBUM)
    fun getAlbum(@Query("album") id: String) : Call<GetAlbumDetailResponse>
}

