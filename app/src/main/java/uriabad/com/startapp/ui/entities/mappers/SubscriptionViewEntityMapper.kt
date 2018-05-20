package uriabad.com.startapp.ui.entities.mappers

import uriabad.com.startapp.model.SubscriptionInfo
import uriabad.com.startapp.ui.entities.SubscriptionViewEntity

fun SubscriptionInfo.toSubscriptionViewEntity(): SubscriptionViewEntity {
    return SubscriptionViewEntity(product, active, trial, status, paydate)
}

fun SubscriptionViewEntity.toSubscriptionInfo(): SubscriptionInfo {
    return SubscriptionInfo(product, active, trial, status, paydate)
}