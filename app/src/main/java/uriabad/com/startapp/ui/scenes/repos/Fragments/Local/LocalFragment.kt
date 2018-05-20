package uriabad.com.startapp.ui.scenes.repos.Fragments.Local

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

class LocalFragment: BaseFragment(), LocalFragmentView {

    @Inject lateinit var presenter: LocalFragmentPresenter
    override var layout: Int = R.layout.fragment_repo
    private val repoAdapter = RepoAdapter("Remove") { repo, position ->
        removeRepoFromLocal(repo, position)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpRecyclerView()
        setUpSwipe()
        presenter.getLocalRepos(hashMapOf())
    }

    private fun setUpSwipe() {
        swipe_layout.setOnRefreshListener {
            repoAdapter.items.clear()
            presenter.getLocalRepos(hashMapOf())
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

    private fun removeRepoFromLocal(repo : RepoViewEntity, position: Int) {
        presenter.deleteRepo(repo, position)
    }

    override fun notifyRemovedSuccess(repo: RepoViewEntity, position: Int) {
        notify("repo removed!")
        with(repoAdapter) {
            items.remove(repo)
            notifyDataSetChanged()
        }
    }

}