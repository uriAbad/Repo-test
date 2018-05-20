package uriabad.com.startapp.repository.entities

data class FeaturedDataEntity(
        val id: String,
        val type: String,
        val title: String,
        val subtitle: String,
        val image: String,
        val duration: String,
        val href: String,
        val available: Boolean
)