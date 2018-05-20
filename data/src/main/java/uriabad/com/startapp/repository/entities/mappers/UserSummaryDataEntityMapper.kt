package uriabad.com.startapp.repository.entities.mappers

import uriabad.com.startapp.model.UserSummaryInfo
import uriabad.com.startapp.network.safe
import uriabad.com.startapp.repository.entities.UserSummaryDataEntity

fun UserSummaryDataEntity.toUserSummaryInfo(): UserSummaryInfo {
    return UserSummaryInfo(this.id.safe(), this.fullname.safe(), this.firstName.safe(),
                           this.lastName.safe(), this.email.safe())
}