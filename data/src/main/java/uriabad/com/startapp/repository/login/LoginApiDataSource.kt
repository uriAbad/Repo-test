package uriabad.com.startapp.repository.login

import uriabad.com.startapp.dependencyinjection.qualifier.LoginApiQueries
import uriabad.com.startapp.repository.datasource.ReadableDataSource
import uriabad.com.startapp.repository.entities.LoginDataEntity
import uriabad.com.startapp.repository.query.Query
import javax.inject.Inject

class LoginApiDataSource @Inject constructor(
        override @LoginApiQueries val queries: MutableSet<Query>)
    : ReadableDataSource<Unit, LoginDataEntity>