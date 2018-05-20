package uriabad.com.startapp.repository.albumDetail

import uriabad.com.startapp.dependencyinjection.qualifier.AlbumDetailApiQueries
import uriabad.com.startapp.repository.datasource.ReadableDataSource
import uriabad.com.startapp.repository.entities.AlbumDetailDataEntity
import uriabad.com.startapp.repository.query.Query
import javax.inject.Inject

class AlbumDetailApiDataSource @Inject constructor(
        override @AlbumDetailApiQueries val queries: MutableSet<Query>)
    : ReadableDataSource<String, AlbumDetailDataEntity>