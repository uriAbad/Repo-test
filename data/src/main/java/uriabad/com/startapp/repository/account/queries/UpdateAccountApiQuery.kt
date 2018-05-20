package uriabad.com.startapp.repository.account.queries

import uriabad.com.startapp.Result
import uriabad.com.startapp.network.getErrorException
import uriabad.com.startapp.network.services.AccountService
import uriabad.com.startapp.repository.entities.UserDataEntity
import uriabad.com.startapp.repository.query.Query
import retrofit2.Retrofit
import javax.inject.Inject

class UpdateAccountApiQuery @Inject constructor(private val retrofit: Retrofit): Query {

    override fun query(parameters: HashMap<String, *>?, queryable: Any?): Result<UserDataEntity, *> {

        parameters?.let {
            val params = parameters as HashMap<String, String>
            val accountService = retrofit.create(AccountService::class.java)
            val response = accountService.updateAccount(params).execute()
            return if (response.isSuccessful) Result.Success(UserDataEntity())
            else Result.Failure(response.getErrorException())
        }

        return Result.Failure()
    }
}