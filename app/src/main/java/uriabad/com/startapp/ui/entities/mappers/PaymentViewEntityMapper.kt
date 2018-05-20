package uriabad.com.startapp.ui.entities.mappers

import uriabad.com.startapp.model.PaymentInfo
import uriabad.com.startapp.ui.entities.PaymentViewEntity

fun PaymentInfo.toPaymentViewEntity(): PaymentViewEntity {
    return PaymentViewEntity(id, date, product, currency, price)
}

fun PaymentViewEntity.toPaymentViewInfo(): PaymentInfo{
    return PaymentInfo(id, date, product, currency, price)
}