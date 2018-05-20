package uriabad.com.startapp.repository.login

import uriabad.com.startapp.Result
import uriabad.com.startapp.model.LoginInfo
import uriabad.com.startapp.repository.LoginRepository
import uriabad.com.startapp.repository.Repository
import uriabad.com.startapp.repository.entities.LoginDataEntity
import uriabad.com.startapp.repository.entities.mappers.toLoginInfo
import uriabad.com.startapp.repository.login.queries.LoginApiQuery
import javax.inject.Inject

class LoginDataRepository @Inject constructor(loginApiDataSource: LoginApiDataSource)
    : LoginRepository, Repository<Unit, LoginDataEntity>() {

    init {
        readableDataSources.add(loginApiDataSource)
    }

    override fun login(params: HashMap<String, String>): Result<LoginInfo, *> {
        val result = query(LoginApiQuery::class.java, params)
        return result.map { it.toLoginInfo() }
    }
}