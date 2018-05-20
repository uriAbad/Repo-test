package uriabad.com.startapp.repository.entities.disk.mapper

import uriabad.com.startapp.repository.entities.UserDataEntity
import uriabad.com.startapp.repository.entities.disk.PaymentDiskEntity
import uriabad.com.startapp.repository.entities.disk.UserDiskEntity
import io.realm.RealmList

fun UserDiskEntity.toUserDataEntity(): UserDataEntity {
    return UserDataEntity(id, fullname, firstName, lastName, username, email, image, address.toAddressDataEntity(),
            preferences.toPreferencesDataEntity(), subscription.toSubscriptionDataEntity(),
            payments.map { it.toPaymentDataEntity() }, banned, versionNumber)
}

fun UserDataEntity.toUserDiskEntity(): UserDiskEntity {
    return UserDiskEntity(id, fullname, firstName, lastName, username, email, image,
            address.toAddressDiskEntity(), preferences.toPreferencesDiskEntity(),
            subscription.toSubscriptionDiskEntity(),
            toPaymentsRealmList(payments.map { it.toPaymentDiskEntity() }),
            banned, versionNumber)
}

fun toPaymentsRealmList(list: List<PaymentDiskEntity>): RealmList<PaymentDiskEntity> {
    val realmList = RealmList<PaymentDiskEntity>()
    realmList.addAll(list)
    return realmList
}