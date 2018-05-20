package uriabad.com.startapp.network.responses

import uriabad.com.startapp.repository.entities.AlbumDetailDataEntity
import com.google.gson.annotations.SerializedName

data class GetAlbumDetailResponse(@SerializedName("data") var albumDetailData :
                                 AlbumDetailDataEntity) : CommonResponse()