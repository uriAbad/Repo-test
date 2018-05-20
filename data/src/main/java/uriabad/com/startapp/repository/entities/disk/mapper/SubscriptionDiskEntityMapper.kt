package uriabad.com.startapp.repository.entities.disk.mapper

import uriabad.com.startapp.repository.entities.SubscriptionDataEntity
import uriabad.com.startapp.repository.entities.disk.SubscriptionDiskDataEntity

fun SubscriptionDiskDataEntity.toSubscriptionDataEntity(): SubscriptionDataEntity {
    return SubscriptionDataEntity (product, active, trial, status, paydate)
}

fun SubscriptionDataEntity.toSubscriptionDiskEntity(): SubscriptionDiskDataEntity {
    return SubscriptionDiskDataEntity(product, active, trial, status, paydate)
}