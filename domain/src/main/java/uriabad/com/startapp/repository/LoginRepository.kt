package uriabad.com.startapp.repository

import uriabad.com.startapp.Result
import uriabad.com.startapp.model.LoginInfo

interface LoginRepository {
    fun login(params: HashMap<String, String>): Result<LoginInfo, *>
}