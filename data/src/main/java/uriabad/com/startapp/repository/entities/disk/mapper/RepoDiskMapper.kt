package uriabad.com.startapp.repository.entities.disk.mapper

import uriabad.com.startapp.repository.entities.RepoDataEntity
import uriabad.com.startapp.repository.entities.disk.RepoDiskEntity

fun RepoDataEntity.toDisk(): RepoDiskEntity = RepoDiskEntity(id, name, description)

fun RepoDiskEntity.toData(): RepoDataEntity = RepoDataEntity(_id, name, description)