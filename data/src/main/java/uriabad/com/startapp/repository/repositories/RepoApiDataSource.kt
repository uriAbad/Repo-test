package uriabad.com.startapp.repository.repositories

import uriabad.com.startapp.dependencyinjection.qualifier.RepoQueries
import uriabad.com.startapp.repository.datasource.ReadableDataSource
import uriabad.com.startapp.repository.entities.RepoDataEntity
import uriabad.com.startapp.repository.query.Query
import javax.inject.Inject

class RepoApiDataSource @Inject constructor(
        @RepoQueries override val queries: MutableSet<Query>
) : ReadableDataSource<Long, RepoDataEntity>