package uriabad.com.startapp.repository.albums

import uriabad.com.startapp.dependencyinjection.qualifier.AlbumApiQueries
import uriabad.com.startapp.repository.datasource.ReadableDataSource
import uriabad.com.startapp.repository.entities.AlbumDataEntity
import uriabad.com.startapp.repository.query.Query
import javax.inject.Inject

class AlbumsApiDataSource @Inject constructor(
        override @AlbumApiQueries val queries: MutableSet<Query>)
    : ReadableDataSource<Unit, AlbumDataEntity>