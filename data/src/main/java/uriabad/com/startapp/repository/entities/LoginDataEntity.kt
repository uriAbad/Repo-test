package uriabad.com.startapp.repository.entities

import com.google.gson.annotations.SerializedName

data class LoginDataEntity (
        @SerializedName("id_token") var bearerToken: String,
        var user: UserDataEntity,
        var status: String = "",
        var timestamp: String = ""
)