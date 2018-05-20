package uriabad.com.startapp.repository.albums.queries

import uriabad.com.startapp.Result
import uriabad.com.startapp.network.getErrorException
import uriabad.com.startapp.network.services.AlbumsService
import uriabad.com.startapp.repository.entities.AlbumDataEntity
import uriabad.com.startapp.repository.query.Query
import retrofit2.Retrofit
import javax.inject.Inject

class AlbumsApiQuery @Inject constructor(private val retrofit: Retrofit) : Query {

    override fun queryAll(parameters: HashMap<String, *>?, queryable: Any?)
            : Result<Collection<AlbumDataEntity>, *> {
        parameters?.let {
            val params = parameters as HashMap<String, String>
            val albumsService = retrofit.create(AlbumsService::class.java)
            val response = albumsService.getAlbums(params).execute()
            return if (response.isSuccessful) Result.Success(response.body()!!.albumsData.albums)
            else Result.Failure(response.getErrorException())
        }
        return Result.Failure()
    }
}