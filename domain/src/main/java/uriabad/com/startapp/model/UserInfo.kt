package uriabad.com.startapp.model

data class UserInfo(
        val id: Long,
        val fullname: String,
        val firstName: String,
        val lastName: String,
        val username: String,
        val email: String,
        val image: String,
        val address: AddressInfo,
        val preferences: PreferencesInfo,
        val subscription: SubscriptionInfo,
        val payments: List<PaymentInfo>,
        val banned: Boolean,
        val versionNumber: String
)