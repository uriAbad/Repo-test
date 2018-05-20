package uriabad.com.startapp.network.responses

import uriabad.com.startapp.repository.entities.UserDataEntity
import com.google.gson.annotations.SerializedName


data class GetAccountResponse(@SerializedName("data") var accountData: UserDataEntity)