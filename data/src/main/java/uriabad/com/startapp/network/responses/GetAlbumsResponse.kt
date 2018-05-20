package uriabad.com.startapp.network.responses

import uriabad.com.startapp.repository.entities.AlbumDataEntity
import com.google.gson.annotations.SerializedName

data class GetAlbumsResponse(@SerializedName("data") var albumsData : AlbumsData,
                             var status: String = "",
                             var timestamp: String = "")

data class AlbumsData(var status: String = "",
                      var timestamp: String = "",
                      @SerializedName("items") var albums: List<AlbumDataEntity>)