package uriabad.com.startapp.repository.albums

import uriabad.com.startapp.Result
import uriabad.com.startapp.model.AlbumInfo
import uriabad.com.startapp.repository.AlbumsRepository
import uriabad.com.startapp.repository.Repository
import uriabad.com.startapp.repository.albums.queries.AlbumsApiQuery
import uriabad.com.startapp.repository.entities.AlbumDataEntity
import uriabad.com.startapp.repository.entities.mappers.toAlbumInfo
import javax.inject.Inject

class AlbumsDataRepository @Inject constructor(albumsApiDataSource: AlbumsApiDataSource)
    : AlbumsRepository, Repository<Unit, AlbumDataEntity>() {

    init {
        readableDataSources.add(albumsApiDataSource)
    }

    override fun getAlbums(params: HashMap<String, String>): Result<List<AlbumInfo>, *> {
        val result = queryAll(AlbumsApiQuery::class.java, params)
        return result.map { albums -> albums.map { it.toAlbumInfo() }}
    }
}