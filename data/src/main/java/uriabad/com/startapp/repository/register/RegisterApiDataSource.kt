package uriabad.com.startapp.repository.register

import uriabad.com.startapp.dependencyinjection.qualifier.RegisterApiQueries
import uriabad.com.startapp.repository.datasource.ReadableDataSource
import uriabad.com.startapp.repository.entities.UserSummaryDataEntity
import uriabad.com.startapp.repository.query.Query
import javax.inject.Inject

class RegisterApiDataSource @Inject constructor(
        override @RegisterApiQueries val queries: MutableSet<Query>)

    : ReadableDataSource<Unit, UserSummaryDataEntity>