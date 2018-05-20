package uriabad.com.startapp.repository.entities.mappers

import uriabad.com.startapp.model.SubscriptionInfo
import uriabad.com.startapp.network.safe
import uriabad.com.startapp.repository.entities.SubscriptionDataEntity

fun SubscriptionDataEntity.toSubscriptionInfo(): SubscriptionInfo {
    return SubscriptionInfo(this.product.safe(), this.active.safe(), this.trial.safe(),
                            this.status.safe(), this.paydate.safe())
}