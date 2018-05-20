package uriabad.com.startapp.repository

import uriabad.com.startapp.Result
import uriabad.com.startapp.model.UserInfo

interface AccountRepository {
    fun getAccount(): Result<UserInfo, *>
    fun getStoredAccount(): Result<UserInfo, *>
    fun updateAccount(userInfo: UserInfo): Result<UserInfo, *>
    fun removeAccount(): Result<Boolean, *>
}