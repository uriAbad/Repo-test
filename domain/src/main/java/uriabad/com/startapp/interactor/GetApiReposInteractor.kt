package uriabad.com.startapp.interactor

import uriabad.com.startapp.Result
import uriabad.com.startapp.model.RepoInfo
import uriabad.com.startapp.repository.RepoRepository
import javax.inject.Inject

class GetApiReposInteractor @Inject constructor(val repository: RepoRepository)
    : Interactor<List<RepoInfo>, HashMap<String, String>>() {

    override fun run(params: HashMap<String, String>): Result<List<RepoInfo>, *> {
        return repository.getExploreRepositories(params)
    }
}