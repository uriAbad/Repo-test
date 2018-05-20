package uriabad.com.startapp.repository.repositories

import com.vicpin.krealmextensions.delete
import com.vicpin.krealmextensions.queryAll
import com.vicpin.krealmextensions.save
import uriabad.com.startapp.Result
import uriabad.com.startapp.dependencyinjection.qualifier.DefaultQueries
import uriabad.com.startapp.repository.datasource.CacheDataSource
import uriabad.com.startapp.repository.entities.RepoDataEntity
import uriabad.com.startapp.repository.entities.disk.RepoDiskEntity
import uriabad.com.startapp.repository.entities.disk.mapper.toData
import uriabad.com.startapp.repository.entities.disk.mapper.toDisk
import uriabad.com.startapp.repository.query.Query
import javax.inject.Inject

class RepoLocalApiDataSource @Inject constructor(
        @DefaultQueries override val queries: MutableSet<Query>
) : CacheDataSource<Long, RepoDataEntity> {

    override fun isValid(value: RepoDataEntity): Boolean {
        return true //not implemented
    }

    override fun addOrUpdate(value: RepoDataEntity): Result<RepoDataEntity, Exception> {
        val result = Result.of { value.toDisk().save() }
        return if (result.isSuccess()) Result.of { value } else Result.Failure()
    }

    override fun getAll(): Result<Collection<RepoDataEntity>, Exception> {
        val repos = RepoDiskEntity().queryAll().map { it.toData() }
        return Result.of { repos }
    }

    override fun deleteByKey(key: Long): Result<Unit, Exception> {
        val result = RepoDiskEntity().delete { it.equalTo("_id",key) }
        return Result.of { result }
    }
}