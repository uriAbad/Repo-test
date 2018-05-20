package uriabad.com.startapp.repository.entities.mappers

import uriabad.com.startapp.model.RepoInfo
import uriabad.com.startapp.network.safe
import uriabad.com.startapp.repository.entities.RepoDataEntity

fun RepoDataEntity.toRepo(): RepoInfo = RepoInfo(id.safe(), name.safe(), description.safe())

fun RepoInfo.toData(): RepoDataEntity = RepoDataEntity(id, name, description)