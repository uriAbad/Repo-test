package uriabad.com.startapp.repository.account

import uriabad.com.startapp.Result
import uriabad.com.startapp.dependencyinjection.qualifier.AccountApiQueries
import uriabad.com.startapp.network.getErrorException
import uriabad.com.startapp.network.services.AccountService
import uriabad.com.startapp.repository.datasource.ReadableDataSource
import uriabad.com.startapp.repository.entities.UserDataEntity
import uriabad.com.startapp.repository.query.Query
import retrofit2.Retrofit
import javax.inject.Inject

class AccountApiDataSource @Inject constructor(override @AccountApiQueries val queries:
                                               MutableSet<Query>,
                                               val retrofit: Retrofit)
    : ReadableDataSource<Unit, UserDataEntity> {

    override fun getByKey(key: Unit): Result<UserDataEntity, Exception> {
        val service = retrofit.create(AccountService::class.java)
        val response = service.getAccount().execute()
        return if (response.isSuccessful) Result.Success(response.body()!!.accountData)
        else Result.Failure(response.getErrorException())
    }
}