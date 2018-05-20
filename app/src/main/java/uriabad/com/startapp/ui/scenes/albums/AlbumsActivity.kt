package uriabad.com.startapp.ui.scenes.albums;

import android.content.Context
import android.content.Intent
import android.support.v7.widget.LinearLayoutManager
import uriabad.com.startapp.R
import uriabad.com.startapp.network.ApiConstants.Companion.DEFAULT_VISIBLE_POSITION
import uriabad.com.startapp.ui.base.BaseActivity
import uriabad.com.startapp.ui.entities.AlbumViewEntity
import uriabad.com.startapp.ui.scenes.albums.adapter.AlbumsAdapter
import com.evernote.android.state.State
import kotlinx.android.synthetic.main.activity_albums.*
import javax.inject.Inject


class AlbumsActivity : BaseActivity(), AlbumsView {

    @Inject lateinit var presenter: AlbumsPresenter
    @State var allAlbums: ArrayList<AlbumViewEntity> = arrayListOf()
    @State var lastAlbumVisiblePos: Int = DEFAULT_VISIBLE_POSITION

    private val albumsAdapter = AlbumsAdapter {
        navigator.navigateToAlbumDetail(this, it)
    }

    companion object {
        const val LIMIT_PER_PAGE = 0

        @JvmStatic fun getIntent(context: Context): Intent {
            return Intent(context, AlbumsActivity::class.java)
        }
    }

    override var layout = R.layout.activity_albums

    override fun onViewLoaded() {
        setSupportActionBar(toolbar)
        setUpViews()
        loadData()
    }

    override fun onResume() {
        super.onResume()
        //loadData()
    }

    private fun setUpViews() {
        swipe_layout.setOnRefreshListener {

        }

        with(albums_recycler) {
            layoutManager = LinearLayoutManager(this@AlbumsActivity)
            adapter = albumsAdapter
        }

    }

    private fun loadData() {
        val albums = ArrayList<AlbumViewEntity>().apply {
        //with(albums) {
            add(AlbumViewEntity("id","title","type","image","duration","subtitle",true))
            add(AlbumViewEntity("id","title","type","image","duration","subtitle",true))
            add(AlbumViewEntity("id","title","type","image","duration","subtitle",true))
            add(AlbumViewEntity("id","title","type","image","duration","subtitle",true))
            add(AlbumViewEntity("id","title","type","image","duration","subtitle",true))
            add(AlbumViewEntity("id","title","type","image","duration","subtitle",true))
            add(AlbumViewEntity("id","title","type","image","duration","subtitle",true))
            add(AlbumViewEntity("id","title","type","image","duration","subtitle",true))
            add(AlbumViewEntity("id","title","type","image","duration","subtitle",true))
            add(AlbumViewEntity("id","title","type","image","duration","subtitle",true))
            add(AlbumViewEntity("id","title","type","image","duration","subtitle",true))
            add(AlbumViewEntity("id","title","type","image","duration","subtitle",true))
            add(AlbumViewEntity("id","title","type","image","duration","subtitle",true))
            add(AlbumViewEntity("id","title","type","image","duration","subtitle",true))
            add(AlbumViewEntity("id","title","type","image","duration","subtitle",true))
            add(AlbumViewEntity("id","title","type","image","duration","subtitle",true))
            add(AlbumViewEntity("id","title","type","image","duration","subtitle",true))
        }

        albumsAdapter.items = albums
    }

    override fun showAlbums(newAlbums: List<AlbumViewEntity>) {

    }

}