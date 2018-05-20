package uriabad.com.startapp.repository.albumDetail.queries

import uriabad.com.startapp.Result
import uriabad.com.startapp.network.ApiConstants
import uriabad.com.startapp.network.getErrorException
import uriabad.com.startapp.network.services.AlbumsService
import uriabad.com.startapp.repository.entities.AlbumDetailDataEntity
import uriabad.com.startapp.repository.query.Query
import retrofit2.Retrofit
import javax.inject.Inject

class AlbumDetailApiQuery @Inject constructor(private val retrofit: Retrofit) : Query {

    override fun query(parameters: HashMap<String, *>?, queryable: Any?)
            : Result<AlbumDetailDataEntity, *> {
        parameters?.let {
            val params = parameters as HashMap<String, String>
            val id = params[ApiConstants.ALBUM_ID] as String
            val albumsService = retrofit.create(AlbumsService::class.java)
            val response = albumsService.getAlbum(id).execute()
            return if (response.isSuccessful) Result.Success(response.body()!!.albumDetailData)
            else Result.Failure(response.getErrorException())
        }
        return Result.Failure()
    }
}