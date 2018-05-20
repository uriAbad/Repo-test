package uriabad.com.startapp.network.responses

import com.google.gson.annotations.SerializedName

data class UpdateAccountResponse(@SerializedName("data") var data: UpdateAccountDataResponse)
data class UpdateAccountDataResponse(var message: String? = "")