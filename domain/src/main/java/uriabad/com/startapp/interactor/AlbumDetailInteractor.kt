package uriabad.com.startapp.interactor

import uriabad.com.startapp.Result
import uriabad.com.startapp.model.AlbumDetailInfo
import uriabad.com.startapp.repository.AlbumDetailRepository
import javax.inject.Inject

class AlbumDetailInteractor @Inject constructor(val repository: AlbumDetailRepository)
    : Interactor<AlbumDetailInfo, String>() {

    override fun run(albumId: String): Result<AlbumDetailInfo, *> {
        return repository.getAlbum(albumId)
    }
}