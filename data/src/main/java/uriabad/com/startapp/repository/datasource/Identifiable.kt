package uriabad.com.startapp.repository.datasource

interface Identifiable<out Key> {
    fun getKey(): Key
}