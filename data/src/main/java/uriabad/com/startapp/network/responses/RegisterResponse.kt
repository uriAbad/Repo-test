package uriabad.com.startapp.network.responses

import uriabad.com.startapp.repository.entities.UserSummaryDataEntity
import com.google.gson.annotations.SerializedName

data class RegisterResponse(@SerializedName("data") var userSummary : UserSummaryDataEntity,
                            var status: String = "",
                            var timestamp: String = "")