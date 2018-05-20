package uriabad.com.startapp.ui.entities.mappers

import uriabad.com.startapp.model.RepoInfo
import uriabad.com.startapp.ui.entities.RepoViewEntity

fun RepoInfo.toRepoView(): RepoViewEntity = RepoViewEntity(id, name, description)

fun RepoViewEntity.toRepo(): RepoInfo = RepoInfo(id, name, description)