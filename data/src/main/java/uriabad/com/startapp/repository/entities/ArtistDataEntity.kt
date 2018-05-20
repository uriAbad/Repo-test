package uriabad.com.startapp.repository.entities

import com.google.gson.annotations.SerializedName

data class ArtistDataEntity (
        var id: Int? = 0,
        var name: String? = "",
        @SerializedName("birth_date") var birthDate: String? = "",
        @SerializedName("death_date") var deathDate: String? = "",
        var city: String? = "",
        var country: String? = "",
        @SerializedName("description_text") var descriptionText: String? = "",
        @SerializedName("background_image") var backgroundImage: String? = "",
        var image: String? = "",
        var href: String? = "",
        var categories: String? = "",
        var origin: String? = "")