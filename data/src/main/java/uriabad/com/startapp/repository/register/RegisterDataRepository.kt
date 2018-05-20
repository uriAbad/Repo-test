package uriabad.com.startapp.repository.register

import uriabad.com.startapp.Result
import uriabad.com.startapp.model.UserSummaryInfo
import uriabad.com.startapp.repository.RegisterRepository
import uriabad.com.startapp.repository.Repository
import uriabad.com.startapp.repository.entities.UserSummaryDataEntity
import uriabad.com.startapp.repository.entities.mappers.toUserSummaryInfo
import uriabad.com.startapp.repository.register.queries.RegisterApiQuery
import javax.inject.Inject

class RegisterDataRepository @Inject constructor(registerApiDataSource: RegisterApiDataSource)
    : RegisterRepository, Repository<Unit, UserSummaryDataEntity>() {

    init {
        readableDataSources.add(registerApiDataSource)
    }

    override fun register(params: HashMap<String, Any>): Result<UserSummaryInfo, *> {
        val result = query(RegisterApiQuery::class.java, params)
        return result.map { it.toUserSummaryInfo() }
    }
}
