package uriabad.com.startapp.repository

import uriabad.com.startapp.Result
import uriabad.com.startapp.model.RepoInfo

interface RepoRepository {
    fun getExploreRepositories(params: HashMap<String, String>): Result<List<RepoInfo>, *>
    fun storeRepo(repo : RepoInfo): Result<Boolean, *>
    fun removeLocalRepo(repo : RepoInfo): Result<Boolean, *>
    fun getLocalRepositories(params: HashMap<String, String>): Result<List<RepoInfo>, *>
}