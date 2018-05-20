package uriabad.com.startapp.repository

import uriabad.com.startapp.Result

interface PreferencesRepository {
    fun get(key: String): Result<String, Exception>
    fun put(key: String, value: String): Result<String, Exception>
    fun delete(key: String): Result<String, Exception>
    fun clear(): Result<String, Exception>
}