package uriabad.com.startapp.repository.entities

data class AlbumDataEntity(
        var id: String = "",
        var title: String = "",
        var type: String = "",
        var image: String = "",
        var duration: String = "",
        var subtitle: String = "",
        var available : Boolean = false
)