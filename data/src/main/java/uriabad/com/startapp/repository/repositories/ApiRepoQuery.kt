package uriabad.com.startapp.repository.repositories

import retrofit2.Retrofit
import uriabad.com.startapp.Result
import uriabad.com.startapp.network.getErrorException
import uriabad.com.startapp.network.services.RepoService
import uriabad.com.startapp.repository.entities.RepoDataEntity
import uriabad.com.startapp.repository.query.Query
import javax.inject.Inject

class ApiRepoQuery @Inject constructor(private val retrofit: Retrofit) : Query {

    override fun queryAll(parameters: HashMap<String, *>?, queryable: Any?): Result<Collection<RepoDataEntity>, *> {
        parameters?.let {
            val params = parameters as HashMap<String, String>
            val repoService = retrofit.create(RepoService::class.java)
            val response = repoService.getRepos(params).execute()
            return if (response.isSuccessful) Result.Success(response.body()!!)
            else Result.Failure(response.getErrorException())
        }
        return Result.Failure()
    }
}