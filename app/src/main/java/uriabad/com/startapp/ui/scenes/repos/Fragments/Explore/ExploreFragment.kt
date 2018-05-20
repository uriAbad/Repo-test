package uriabad.com.startapp.ui.scenes.repos.Fragments.Explore

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import kotlinx.android.synthetic.main.fragment_repo.*
import uriabad.com.startapp.R
import uriabad.com.startapp.ui.base.BaseFragment
import uriabad.com.startapp.ui.entities.RepoViewEntity
import uriabad.com.startapp.ui.scenes.repos.adapter.RepoAdapter
import javax.inject.Inject

class ExploreFragment: BaseFragment(), ExploreFragmentView {

    @Inject lateinit var presenter: ExploreFragmentPresenter
    override var layout: Int = R.layout.fragment_repo
    private val repoAdapter = RepoAdapter("add") { repo, _ -> addRepoToLocal(repo) }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpRecyclerView()
        setUpSwipe()
        presenter.getApiRepos(hashMapOf())
    }

    private fun setUpSwipe() {
        swipe_layout.setOnRefreshListener {
            repoAdapter.items.clear()
            presenter.getApiRepos(hashMapOf())
        }
    }

    private fun setUpRecyclerView() = with(recycler_repos) {
        layoutManager = LinearLayoutManager(activity)
        adapter = repoAdapter
    }

    override fun onReposRetrieved(repos: List<RepoViewEntity>) {
        swipe_layout.isRefreshing = false
        repoAdapter.items = ArrayList(repos)
    }

    override fun onError(errorMessage: String) {
        notify(errorMessage)
    }

    override fun showLoader() { loader.visibility = VISIBLE }

    override fun hideLoader() { loader.visibility = GONE }

    private fun addRepoToLocal(repo : RepoViewEntity) {
        presenter.storeRepo(repo)
    }

    override fun notifyStoredSuccess(repo: RepoViewEntity) {
        notify("repo saved!")
    }
}