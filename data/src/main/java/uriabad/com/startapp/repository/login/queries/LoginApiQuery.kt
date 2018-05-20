package uriabad.com.startapp.repository.login.queries

import uriabad.com.startapp.Result
import uriabad.com.startapp.network.getErrorException
import uriabad.com.startapp.network.services.AuthenticationService
import uriabad.com.startapp.repository.entities.LoginDataEntity
import uriabad.com.startapp.repository.query.Query
import retrofit2.Retrofit
import javax.inject.Inject


class LoginApiQuery @Inject constructor(private val retrofit: Retrofit) : Query {

    override fun query(parameters: HashMap<String, *>?, queryable: Any?)
            : Result<LoginDataEntity, *> {

        parameters?.let {
            val params = parameters as HashMap<String, String>
            val loginService = retrofit.create(AuthenticationService::class.java)
            val response = loginService.login(params).execute()
            return if (response.isSuccessful) Result.Success(response.body()!!.loginData)
            else Result.Failure(response.getErrorException())
        }
        return Result.Failure()
    }
}