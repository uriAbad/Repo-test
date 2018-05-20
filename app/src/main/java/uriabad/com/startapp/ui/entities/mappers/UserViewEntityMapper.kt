package uriabad.com.startapp.ui.entities.mappers

import uriabad.com.startapp.model.UserInfo
import uriabad.com.startapp.ui.entities.UserViewEntity

fun UserInfo.toUserViewEntity(): UserViewEntity {
    return UserViewEntity(this.id, this.fullname, this.firstName, this.lastName,
            this.username, this.email, this.image, this.address.toAddressViewEntity(),
            this.preferences.toPreferencesViewEntity(), this.subscription.toSubscriptionViewEntity(),
            this.payments.map { it.toPaymentViewEntity() }, this.banned, this.versionNumber)
}

fun UserViewEntity.toUserInfo(): UserInfo {
    return UserInfo(this.id, this.fullname, this.firstName, this.lastName,
            this.username, this.email, this.image, this.address.toAddressInfo(),
            this.preferences.toPreferencesInfo(), this.subscription.toSubscriptionInfo(),
            this.payments.map { it.toPaymentViewInfo() }, this.banned, this.versionNumber)
}