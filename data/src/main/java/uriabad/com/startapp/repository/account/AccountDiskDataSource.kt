package uriabad.com.startapp.repository.account

import uriabad.com.startapp.Result
import uriabad.com.startapp.dependencyinjection.qualifier.DefaultQueries
import uriabad.com.startapp.repository.datasource.CacheDataSource
import uriabad.com.startapp.repository.entities.UserDataEntity
import uriabad.com.startapp.repository.entities.disk.UserDiskEntity
import uriabad.com.startapp.repository.entities.disk.mapper.toUserDiskEntity
import uriabad.com.startapp.repository.query.Query
import com.vicpin.krealmextensions.deleteAll
import com.vicpin.krealmextensions.save
import javax.inject.Inject

class AccountDiskDataSource @Inject constructor(
        override @DefaultQueries val queries: MutableSet<Query>)
    : CacheDataSource<Unit, UserDataEntity> {

    override fun isValid(value: UserDataEntity) = true

    override fun addOrUpdate(value: UserDataEntity): Result<UserDataEntity, Exception> {
        return Result.of {
            value.toUserDiskEntity().save()
            value
        }
    }

    override fun deleteAll(): Result<Unit, *> = Result.of { UserDiskEntity().deleteAll() }
}