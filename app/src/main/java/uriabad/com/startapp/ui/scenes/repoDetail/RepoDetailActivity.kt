package uriabad.com.startapp.ui.scenes.repoDetail

import android.content.Context
import android.content.Intent
import kotlinx.android.synthetic.main.activity_repo_detail.*
import uriabad.com.startapp.R
import uriabad.com.startapp.ui.base.BaseActivity
import uriabad.com.startapp.ui.entities.RepoViewEntity

class RepoDetailActivity: BaseActivity(), RepoDetailView {

    lateinit var repo : RepoViewEntity

    companion object {
        const val PARAM_REPO = "PARAM_REPO"

        @JvmStatic fun getIntent(context: Context, repo: RepoViewEntity): Intent =
                Intent(context, RepoDetailActivity::class.java).apply {
                    putExtra(PARAM_REPO, repo)
                }
    }

    override var layout = R.layout.activity_repo_detail

    override fun onViewLoaded() {
        setSupportActionBar(toolbar)
        supportActionBar?.apply {
            setDisplayHomeAsUpEnabled(true)
            setDisplayShowHomeEnabled(true)
        }
        repo = intent.getParcelableExtra(PARAM_REPO)

        //NOT ENOUGH TIME TO CONTINUE DOING THINGS..... :(
    }
}