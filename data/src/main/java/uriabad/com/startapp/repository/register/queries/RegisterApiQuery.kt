package uriabad.com.startapp.repository.register.queries

import uriabad.com.startapp.Result
import uriabad.com.startapp.network.ApiConstants
import uriabad.com.startapp.network.getErrorException
import uriabad.com.startapp.network.services.AuthenticationService
import uriabad.com.startapp.repository.entities.UserSummaryDataEntity
import uriabad.com.startapp.repository.query.Query
import retrofit2.Retrofit
import javax.inject.Inject

class RegisterApiQuery @Inject constructor(private val retrofit: Retrofit) : Query {

    override fun query(parameters: HashMap<String, *>?, queryable: Any?)
            : Result<UserSummaryDataEntity, *> {

        parameters?.let {
            val email = parameters[ApiConstants.EMAIL] as String
            val password = parameters[ApiConstants.PASSWORD] as String
            val confirm = parameters[ApiConstants.CONFIRM_PASSWORD] as String
            val newsletter = parameters[ApiConstants.NEWSLETTER] as Boolean
            val trial = parameters[ApiConstants.TRIAL] as Boolean
            val registerService = retrofit.create(AuthenticationService::class.java)
            val response = registerService.register(email, password, confirm, newsletter, trial)
                    .execute()
            return if (response.isSuccessful) Result.Success(response.body()!!.userSummary)
            else Result.Failure(response.getErrorException())
        }
        return Result.Failure()
    }
}