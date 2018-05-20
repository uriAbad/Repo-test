package uriabad.com.startapp.repository.repositories

import uriabad.com.startapp.Result
import uriabad.com.startapp.model.RepoInfo
import uriabad.com.startapp.repository.RepoRepository
import uriabad.com.startapp.repository.Repository
import uriabad.com.startapp.repository.entities.RepoDataEntity
import uriabad.com.startapp.repository.entities.mappers.toData
import uriabad.com.startapp.repository.entities.mappers.toRepo
import uriabad.com.startapp.repository.policy.ReadPolicy
import javax.inject.Inject

class RepoDataRepository
@Inject constructor(repoApiDataSource: RepoApiDataSource, repoDiskDataSouce: RepoLocalApiDataSource)
    : RepoRepository, Repository<Long, RepoDataEntity>() {

    init {
        readableDataSources.add(repoApiDataSource)
        cacheDataSources.add(repoDiskDataSouce)
        writableDataSources.add(repoDiskDataSouce)
    }

    override fun getExploreRepositories(params: HashMap<String, String>): Result<List<RepoInfo>, *> {
        val result = queryAll(ApiRepoQuery::class.java, params).map {
            it.map { it.toRepo() }
        }
        return result
    }

    override fun storeRepo(repo: RepoInfo): Result<Boolean, *> {
        val result = addOrUpdate(repo.toData())
        return if (result.isSuccess()) Result.of { true } else Result.Failure()
    }

    override fun getLocalRepositories(params: HashMap<String, String>): Result<List<RepoInfo>, *> {
        return getAll(ReadPolicy.CACHE_ONLY).map { it.map { it.toRepo() } }
    }

    override fun removeLocalRepo(repo: RepoInfo): Result<Boolean, *> {
        val result = deleteByKey(repo.id)
        return if (result.isSuccess()) Result.of { true } else Result.Failure()
    }
}