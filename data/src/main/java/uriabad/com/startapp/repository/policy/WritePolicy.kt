package uriabad.com.startapp.repository.policy

enum class WritePolicy {
    WRITE_CACHE_ONLY,
    WRITE_ALL;

    fun writeCache(): Boolean {
        return this == WRITE_CACHE_ONLY
    }

}