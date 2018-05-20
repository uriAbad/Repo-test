package uriabad.com.startapp.repository.datasource

interface TimeProvider {
    fun currentTimeMillis(): Long
}