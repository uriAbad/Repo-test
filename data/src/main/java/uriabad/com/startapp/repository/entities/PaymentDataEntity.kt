package uriabad.com.startapp.repository.entities

data class PaymentDataEntity(
        var id: Long = 0,
        var date: String = "",
        var product: String = "",
        var currency: String = "",
        var price: Double = 0.0
)