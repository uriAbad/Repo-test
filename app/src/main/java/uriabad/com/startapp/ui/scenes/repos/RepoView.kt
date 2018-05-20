package uriabad.com.startapp.ui.scenes.repos;

import uriabad.com.startapp.ui.base.ErrorBaseView
import uriabad.com.startapp.ui.entities.AlbumViewEntity


interface RepoView : ErrorBaseView {
    fun showAlbums(albums: List<AlbumViewEntity>)
}