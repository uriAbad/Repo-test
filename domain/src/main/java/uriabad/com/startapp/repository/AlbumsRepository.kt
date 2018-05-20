package uriabad.com.startapp.repository

import uriabad.com.startapp.Result
import uriabad.com.startapp.model.AlbumInfo

interface AlbumsRepository {
    fun getAlbums(params: HashMap<String, String>): Result<List<AlbumInfo>, *>
}