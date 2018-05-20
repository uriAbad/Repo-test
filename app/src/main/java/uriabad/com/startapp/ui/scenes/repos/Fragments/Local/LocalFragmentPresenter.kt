package uriabad.com.startapp.ui.scenes.repos.Fragments.Local

import uriabad.com.startapp.interactor.DeleteRepoInteractor
import uriabad.com.startapp.interactor.GetLocalReposInteractor
import uriabad.com.startapp.ui.entities.RepoViewEntity
import uriabad.com.startapp.ui.entities.mappers.toRepo
import uriabad.com.startapp.ui.entities.mappers.toRepoView
import javax.inject.Inject

class LocalFragmentPresenter @Inject constructor(
        val view: LocalFragmentView,
        private val localReposInteractor: GetLocalReposInteractor,
        private val deleteRepoInteractor: DeleteRepoInteractor) {

    fun getLocalRepos(params: HashMap<String, String>) {
        view.showLoader()
        localReposInteractor.execute(params) {
            it.success {
                view.hideLoader()
                view.onReposRetrieved(it.map { it.toRepoView() })
            }
            it.failure {
                view.hideLoader()
            }
        }
    }

    fun deleteRepo(repo: RepoViewEntity, position: Int) {
        view.showLoader()
        deleteRepoInteractor.execute(repo.toRepo()) {
            it.success {
                view.hideLoader()
                view.notifyRemovedSuccess(repo, position)
            }
            it.failure {
                view.hideLoader()
                view.onError(it.message ?: "Unknown error")
            }
        }
    }

}