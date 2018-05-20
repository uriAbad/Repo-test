package uriabad.com.startapp.repository.entities

import com.google.gson.annotations.SerializedName

data class UserDataEntity(var id: Long = 0,
                          var fullname: String = "",
                          @SerializedName("first_name") var firstName: String = "",
                          @SerializedName("last_name") var lastName: String = "",
                          var username: String = "",
                          var email: String = "",
                          var image: String = "",
                          var address: AddressDataEntity = AddressDataEntity(),
                          var preferences: PreferencesDataEntity = PreferencesDataEntity(),
                          var subscription: SubscriptionDataEntity = SubscriptionDataEntity(),
                          var payments: List<PaymentDataEntity> = arrayListOf(),
                          var banned: Boolean = false,
                          @SerializedName("version_number") var versionNumber: String = ""
)