package uriabad.com.startapp.repository.albumDetail

import uriabad.com.startapp.Result
import uriabad.com.startapp.model.AlbumDetailInfo
import uriabad.com.startapp.network.ApiConstants
import uriabad.com.startapp.repository.AlbumDetailRepository
import uriabad.com.startapp.repository.Repository
import uriabad.com.startapp.repository.albumDetail.queries.AlbumDetailApiQuery
import uriabad.com.startapp.repository.entities.AlbumDetailDataEntity
import uriabad.com.startapp.repository.entities.mappers.toAlbumDetailInfo
import javax.inject.Inject

class AlbumDetailDataRepository @Inject constructor(albumDetailApiDataSource: AlbumDetailApiDataSource)
    : AlbumDetailRepository, Repository<String, AlbumDetailDataEntity>() {

    init {
        readableDataSources.add(albumDetailApiDataSource)
    }

    override fun getAlbum(albumId: String): Result<AlbumDetailInfo, *> {
        val params = hashMapOf(ApiConstants.ALBUM_ID to albumId)
        val result = query(AlbumDetailApiQuery::class.java, params)
        return result.map { it.toAlbumDetailInfo() }
    }
}