package uriabad.com.startapp.repository.entities.disk.mapper

import uriabad.com.startapp.repository.entities.PaymentDataEntity
import uriabad.com.startapp.repository.entities.disk.PaymentDiskEntity

fun PaymentDiskEntity.toPaymentDataEntity(): PaymentDataEntity {
    return PaymentDataEntity(id, date, product, currency, price)
}

fun PaymentDataEntity.toPaymentDiskEntity(): PaymentDiskEntity {
    return PaymentDiskEntity (id, date, product, currency, price)
}