package uriabad.com.startapp.interactor

import uriabad.com.startapp.Result
import uriabad.com.startapp.model.AlbumInfo
import uriabad.com.startapp.repository.AlbumsRepository
import javax.inject.Inject

class AlbumsInteractor @Inject constructor(val repository: AlbumsRepository)
    : Interactor<List<AlbumInfo>, HashMap<String, String>>() {

    override fun run(params: HashMap<String, String>): Result<List<AlbumInfo>, *> {
        return repository.getAlbums(params)
    }
}