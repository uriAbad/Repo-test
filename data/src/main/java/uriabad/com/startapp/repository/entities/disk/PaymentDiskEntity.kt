package uriabad.com.startapp.repository.entities.disk

import io.realm.RealmObject

open class PaymentDiskEntity(
        var id: Long = 0,
        var date: String = "",
        var product: String = "",
        var currency: String = "",
        var price: Double = 0.0
) : RealmObject()