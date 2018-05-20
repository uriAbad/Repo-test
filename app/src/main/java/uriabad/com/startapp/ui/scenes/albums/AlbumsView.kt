package uriabad.com.startapp.ui.scenes.albums;

import uriabad.com.startapp.ui.base.ErrorBaseView
import uriabad.com.startapp.ui.entities.AlbumViewEntity


interface AlbumsView : ErrorBaseView {
    fun showAlbums(albums: List<AlbumViewEntity>)
}