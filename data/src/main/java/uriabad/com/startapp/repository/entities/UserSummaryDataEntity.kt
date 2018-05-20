package uriabad.com.startapp.repository.entities

import com.google.gson.annotations.SerializedName

data class UserSummaryDataEntity(var id: Long = 0,
                                 var fullname: String = "",
                                 @SerializedName("first_name") var firstName: String = "",
                                 @SerializedName("last_name") var lastName: String = "",
                                 var email: String = ""
)