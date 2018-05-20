package uriabad.com.startapp.repository

import uriabad.com.startapp.Result
import uriabad.com.startapp.model.AlbumDetailInfo

interface AlbumDetailRepository {
    fun getAlbum(albumId: String): Result<AlbumDetailInfo, *>
}