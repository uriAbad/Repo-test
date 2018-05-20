package uriabad.com.startapp.network

interface ApiEndpoints {
    companion object {
        const val BASE_URL = "http://staging.api.wurcly.com/v1/"
        const val LOGIN = "user/login"
        const val USER = "user"
        const val ALBUMS = "albums"
        const val ALBUM = "album"
        const val EXPLORE = "explore/"
        const val ARTISTS = EXPLORE + "artists"
        const val COMPOSERS = EXPLORE + "composers"
        const val MOODS = EXPLORE + "moods"
        const val FEATURED = "featured"
    }
}