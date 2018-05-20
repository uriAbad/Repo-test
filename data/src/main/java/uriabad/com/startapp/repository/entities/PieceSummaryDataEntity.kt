package uriabad.com.startapp.repository.entities

import com.google.gson.annotations.SerializedName

data class PieceSummaryDataEntity(
        var id: String = "",
        var type: String = "",
        var title: String = "",
        @SerializedName("work_id") var workId: String = "",
        var duration: Long = 0
)