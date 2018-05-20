package uriabad.com.startapp.ui.scenes.repos.Fragments.Explore

import uriabad.com.startapp.ui.entities.RepoViewEntity

interface ExploreFragmentView {

    fun showLoader()
    fun hideLoader()
    fun onReposRetrieved(repos: List<RepoViewEntity>)
    fun onError(errorMessage: String)
    fun notifyStoredSuccess(repo: RepoViewEntity)
}