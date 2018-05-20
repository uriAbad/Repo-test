package uriabad.com.startapp.ui.scenes.albumDetail

import android.content.Context
import android.content.Intent
import android.support.v7.widget.LinearLayoutManager
import uriabad.com.startapp.R
import uriabad.com.startapp.ui.base.BaseActivity
import uriabad.com.startapp.ui.entities.AlbumDetailViewEntity
import uriabad.com.startapp.ui.entities.AlbumViewEntity
import kotlinx.android.synthetic.main.activity_album_detail.*
import javax.inject.Inject


class AlbumDetailActivity: BaseActivity(), AlbumDetailView {

    @Inject lateinit var presenter: AlbumDetailPresenter
    private lateinit var album: AlbumViewEntity

    companion object Intent {
        private const val ALBUM = "ALBUM"

        @JvmStatic fun getIntent(context: Context, album: AlbumViewEntity) =
                Intent(context, AlbumDetailActivity::class.java).apply {
                    putExtra(ALBUM, album)
                }
    }

    override var layout = R.layout.activity_album_detail

    override fun onViewLoaded() {
        album = intent.getParcelableExtra(ALBUM) ?: AlbumViewEntity.empty()

     //   onLoading(pieces_recycler_view, detail_progress_bar)

        //presenter.onViewLoaded()

        //detail_image.load(album.image)
        //album_name.text = album.title
        //album_playtime.text = album.duration

        setUpToolbar()
        setUpRecyclerView()
    }

    private fun setUpToolbar() {
        setSupportActionBar(toolbar)
        supportActionBar?.let {
            it.setDisplayHomeAsUpEnabled(true)
            it.setDisplayShowHomeEnabled(true)
        }
        //detail_image_toolbar.detail_toolbar.setOnClickListener{ presenter.onBackBtnPressed() }
        //val toolbar = detail_image_toolbar.detail_toolbar as Toolbar
        //(detail_image_toolbar as AppBarLayout).setParallaxBehaviour(toolbar,
//                coordinator_toolbar_title, album.title)
    }

    private fun setUpRecyclerView() {
        val linearLayoutManager = LinearLayoutManager(this)
       // pieces_recycler_view.layoutManager = linearLayoutManager
        //pieces_recycler_view.adapter = piecesAdapter
    }

    override fun getAlbumViewEntity(): AlbumViewEntity {
        return album
    }

    override fun displayAlbumInfo(albumDetailViewEntity: AlbumDetailViewEntity) {
        //album_label.text = albumDetailViewEntity.label.name
        //piecesAdapter.set(albumDetailViewEntity.pieces.items)
      //  onInfoRetrieved(pieces_recycler_view, detail_progress_bar)
    }

}