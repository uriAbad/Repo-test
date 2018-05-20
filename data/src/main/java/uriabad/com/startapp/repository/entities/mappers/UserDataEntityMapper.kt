package uriabad.com.startapp.repository.entities.mappers

import uriabad.com.startapp.model.UserInfo
import uriabad.com.startapp.network.safe
import uriabad.com.startapp.repository.entities.UserDataEntity

fun UserDataEntity.toUserInfo(): UserInfo {
    return UserInfo(this.id.safe(), this.fullname.safe(), this.firstName.safe(), this.lastName.safe(),
            this.username.safe(), this.email.safe(), this.image.safe(), this.address.toAddressInfo(),
            this.preferences.toPreferencesInfo(), this.subscription.toSubscriptionInfo(),
            this.payments.map {it.toPaymentInfo()}, this.banned.safe(), this.versionNumber.safe())
}