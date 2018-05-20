package uriabad.com.startapp.ui.scenes.albumDetail

import uriabad.com.startapp.interactor.AlbumDetailInteractor
import uriabad.com.startapp.ui.base.BasePresenter
import uriabad.com.startapp.ui.entities.mappers.toAlbumDetailViewEntity
import javax.inject.Inject

class AlbumDetailPresenter @Inject constructor(val view: AlbumDetailView,
                                               private val albumDetailInteractor: AlbumDetailInteractor)
                                               : BasePresenter() {
    fun onViewLoaded() {
        getAlbumDetail()
    }

    private fun getAlbumDetail() {
        val albumId = view.getAlbumViewEntity().id
        albumDetailInteractor.execute(albumId) {
            result ->
            result.success {
                view.displayAlbumInfo(it.toAlbumDetailViewEntity())
            }
            result.failure {
                exception -> exceptionHandler.notifyException(view, exception)
            }
        }
    }

    fun onBackBtnPressed() {
        view.onBackPressed()
    }
}