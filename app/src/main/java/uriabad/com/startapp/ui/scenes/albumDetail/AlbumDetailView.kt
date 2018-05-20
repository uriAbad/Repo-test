package uriabad.com.startapp.ui.scenes.albumDetail

import uriabad.com.startapp.ui.base.ErrorBaseView
import uriabad.com.startapp.ui.base.NavigationBaseView
import uriabad.com.startapp.ui.entities.AlbumDetailViewEntity
import uriabad.com.startapp.ui.entities.AlbumViewEntity

interface AlbumDetailView: ErrorBaseView, NavigationBaseView {
    fun getAlbumViewEntity(): AlbumViewEntity
    fun displayAlbumInfo(albumDetailViewEntity: AlbumDetailViewEntity)
}