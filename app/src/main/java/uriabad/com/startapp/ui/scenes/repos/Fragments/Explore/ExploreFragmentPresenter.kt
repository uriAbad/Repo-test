package uriabad.com.startapp.ui.scenes.repos.Fragments.Explore

import uriabad.com.startapp.interactor.GetApiReposInteractor
import uriabad.com.startapp.interactor.StoreRepoInteractor
import uriabad.com.startapp.ui.entities.RepoViewEntity
import uriabad.com.startapp.ui.entities.mappers.toRepo
import uriabad.com.startapp.ui.entities.mappers.toRepoView
import javax.inject.Inject

class ExploreFragmentPresenter @Inject constructor(
        val view: ExploreFragmentView,
        private val apiReposInteractor: GetApiReposInteractor,
        private val storeRepoInteractor: StoreRepoInteractor) {

    fun getApiRepos(params: HashMap<String, String>) {
        view.showLoader()
        apiReposInteractor.execute(params) {
            it.success {
                view.hideLoader()
                view.onReposRetrieved(it.map { it.toRepoView() })
            }
            it.failure {
                view.hideLoader()
                view.onError(it.message ?: "Unknown error")
            }
        }
    }

    fun storeRepo(repo: RepoViewEntity) {
        view.showLoader()
        storeRepoInteractor.execute(repo.toRepo()) {
            it.success {
                view.hideLoader()
                view.notifyStoredSuccess(repo)
            }
            it.failure {
                view.hideLoader()
                view.onError(it.message ?: "Unknown error")
            }
        }
    }

}