package uriabad.com.startapp.network.responses

import uriabad.com.startapp.repository.entities.LoginDataEntity
import com.google.gson.annotations.SerializedName

data class LoginResponse(@SerializedName("data") var loginData : LoginDataEntity)