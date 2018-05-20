package uriabad.com.startapp.repository.account.queries

import uriabad.com.startapp.Result
import uriabad.com.startapp.repository.entities.UserDataEntity
import uriabad.com.startapp.repository.entities.disk.UserDiskEntity
import uriabad.com.startapp.repository.entities.disk.mapper.toUserDataEntity
import uriabad.com.startapp.repository.query.Query
import com.vicpin.krealmextensions.queryFirst
import javax.inject.Inject

class GetAccountDiskQuery @Inject constructor() : Query {

    override fun query(parameters: HashMap<String, *>?, queryable: Any?): Result<UserDataEntity, *> {
        return Result.of { UserDiskEntity().queryFirst()?.toUserDataEntity() }
    }
}