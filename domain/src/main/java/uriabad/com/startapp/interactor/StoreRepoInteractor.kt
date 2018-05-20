package uriabad.com.startapp.interactor

import uriabad.com.startapp.Result
import uriabad.com.startapp.model.RepoInfo
import uriabad.com.startapp.repository.RepoRepository
import javax.inject.Inject

class StoreRepoInteractor @Inject constructor(val repository: RepoRepository)
    : Interactor<Boolean, RepoInfo>() {

    override fun run(params: RepoInfo): Result<Boolean, *> {
        return repository.storeRepo(params)
    }
}
