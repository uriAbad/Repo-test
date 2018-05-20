package uriabad.com.startapp.ui.scenes.albums;

import uriabad.com.startapp.interactor.AlbumsInteractor
import uriabad.com.startapp.ui.base.BasePresenter
import uriabad.com.startapp.ui.entities.mappers.toAlbumViewEntity
import javax.inject.Inject


class AlbumsPresenter @Inject constructor(val view: AlbumsView,
                                          private val getAlbumsInteractor: AlbumsInteractor)
    : BasePresenter() {

    fun onResume(params: HashMap<String, String>) = getAlbums(params)

    fun getAlbums(params: HashMap<String, String>) {
        getAlbumsInteractor.execute(params) {
            result ->
            result.success {
                value -> view.showAlbums(value.map { it.toAlbumViewEntity() })
            }
            result.failure { exception -> exceptionHandler.notifyException(view, exception) }
        }
    }

}