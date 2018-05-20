package uriabad.com.startapp.model

data class SubscriptionInfo(
        val product: String,
        val active : Boolean,
        val trial : Boolean,
        val status : String,
        val paydate : String
)