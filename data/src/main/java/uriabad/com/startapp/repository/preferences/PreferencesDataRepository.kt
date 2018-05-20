package uriabad.com.startapp.repository.preferences

import uriabad.com.startapp.repository.PreferencesRepository
import javax.inject.Inject

class PreferencesDataRepository @Inject constructor(
        private val sharedPreferencesDataSource: SharedPreferencesDataSource)
    : PreferencesRepository  {

    override fun put(key: String, value: String) = sharedPreferencesDataSource.putKey(key, value)
    override fun get(key: String) = sharedPreferencesDataSource.getByKey(key)
    override fun delete(key: String) = sharedPreferencesDataSource.deleteKey(key)
    override fun clear() = sharedPreferencesDataSource.clear()
}