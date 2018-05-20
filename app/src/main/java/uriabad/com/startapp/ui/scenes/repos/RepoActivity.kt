package uriabad.com.startapp.ui.scenes.repos;

import android.content.Context
import android.content.Intent
import kotlinx.android.synthetic.main.activity_albums.*
import uriabad.com.startapp.R
import uriabad.com.startapp.ui.ViewPagerAdapter
import uriabad.com.startapp.ui.base.BaseActivity
import uriabad.com.startapp.ui.entities.AlbumViewEntity
import uriabad.com.startapp.ui.scenes.repos.Fragments.Explore.ExploreFragment
import uriabad.com.startapp.ui.scenes.repos.Fragments.Local.LocalFragment
import javax.inject.Inject


class RepoActivity : BaseActivity(), RepoView {

    private val exploreFragment by lazy { ExploreFragment() }
    private val localFragment by lazy { LocalFragment() }

    @Inject lateinit var presenter: RepoPresenter

    companion object {
        @JvmStatic fun getIntent(context: Context): Intent {
            return Intent(context, RepoActivity::class.java)
        }
    }

    override var layout = R.layout.activity_albums

    override fun onViewLoaded() {
        setSupportActionBar(toolbar)
        setUpTabLayout()
        setUpViews()
        loadData()
    }

    private fun setUpTabLayout() {
        val adapter = ViewPagerAdapter(supportFragmentManager)
        adapter.addFragment(exploreFragment, "Explore")
        adapter.addFragment(localFragment, "Local")
        viewPager.adapter = adapter
        tabs.setupWithViewPager(viewPager)
    }

    override fun onResume() {
        super.onResume()
        //loadData()
    }

    private fun setUpViews() {
      //  swipe_layout.setOnRefreshListener {
//
  //      }

        ///with(albums_recycler) {
           // layoutManager = LinearLayoutManager(this@RepoActivity)
            //adapter = albumsAdapter
        //}

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

       // albumsAdapter.items = albums
    }

    override fun showAlbums(newAlbums: List<AlbumViewEntity>) {

    }

}