package uriabad.com.startapp.ui.scenes.repos.Fragments.Local

import uriabad.com.startapp.ui.entities.RepoViewEntity

interface LocalFragmentView {

    fun showLoader()
    fun hideLoader()
    fun onReposRetrieved(repos: List<RepoViewEntity>)
    fun onError(errorMessage: String)
    fun notifyRemovedSuccess(repo: RepoViewEntity, position: Int)
}