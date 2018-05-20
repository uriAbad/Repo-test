package uriabad.com.startapp.repository.entities

data class SubscriptionDataEntity(
        var product: String = "",
        var active : Boolean = false,
        var trial : Boolean = false,
        var status : String = "",
        var paydate : String = ""
)