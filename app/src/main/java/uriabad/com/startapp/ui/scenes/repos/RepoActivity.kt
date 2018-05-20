package uriabad.com.startapp.ui.scenes.repos;

import android.content.Context
import android.content.Intent
import kotlinx.android.synthetic.main.activity_repo.*
import uriabad.com.startapp.R
import uriabad.com.startapp.ui.ViewPagerAdapter
import uriabad.com.startapp.ui.base.BaseActivity
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

    override var layout = R.layout.activity_repo

    override fun onViewLoaded() {
        setSupportActionBar(toolbar)
        setUpTabLayout()
    }

    private fun setUpTabLayout() {
        val adapter = ViewPagerAdapter(supportFragmentManager).apply {
            addFragment(exploreFragment, "Explore")
            addFragment(localFragment, "Local")
        }

        viewPager.adapter = adapter
        tabs.setupWithViewPager(viewPager)
    }


}