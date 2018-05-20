package uriabad.com.startapp.repository.entities.mappers

import uriabad.com.startapp.model.PaymentInfo
import uriabad.com.startapp.network.safe
import uriabad.com.startapp.repository.entities.PaymentDataEntity

fun PaymentDataEntity.toPaymentInfo(): PaymentInfo {
    return PaymentInfo(this.id.safe(), this.date.safe(), this.product.safe(), this.currency.safe(),
                       this.price.safe())
}