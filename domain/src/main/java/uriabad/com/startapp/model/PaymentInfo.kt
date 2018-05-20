package uriabad.com.startapp.model

data class PaymentInfo(
        val id: Long,
        val date: String,
        val product: String,
        val currency: String,
        val price: Double
)