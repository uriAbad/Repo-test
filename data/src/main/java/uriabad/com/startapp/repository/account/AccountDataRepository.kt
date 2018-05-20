package uriabad.com.startapp.repository.account

import uriabad.com.startapp.Result
import uriabad.com.startapp.model.UserInfo
import uriabad.com.startapp.network.ApiConstants
import uriabad.com.startapp.repository.AccountRepository
import uriabad.com.startapp.repository.Repository
import uriabad.com.startapp.repository.account.queries.GetAccountDiskQuery
import uriabad.com.startapp.repository.account.queries.SaveAccountDiskQuery
import uriabad.com.startapp.repository.account.queries.UpdateAccountApiQuery
import uriabad.com.startapp.repository.entities.UserDataEntity
import uriabad.com.startapp.repository.entities.mappers.toUserInfo
import javax.inject.Inject

class AccountDataRepository @Inject constructor(accountApiDataSource: AccountApiDataSource,
                                                accountDiskDataSource: AccountDiskDataSource)
    : AccountRepository, Repository<Unit, UserDataEntity>() {

    init {
        readableDataSources.add(accountApiDataSource)
        cacheDataSources.add(accountDiskDataSource)
    }

    override fun getAccount(): Result<UserInfo, *> {
        val result = getByKey(Unit)
        return result.map {
            user -> saveAccountInDisk(user)
            user.toUserInfo()
        }
    }

    override fun getStoredAccount(): Result<UserInfo, *> {
        val result = query(GetAccountDiskQuery::class.java, null)
        return when (result) {
            is Result.Success -> result.map { it.toUserInfo() }
            is Result.Failure -> getAccount()
        }
    }

    private fun saveAccountInDisk(accountInfo: UserDataEntity) {
        query(SaveAccountDiskQuery::class.java,
              hashMapOf(SaveAccountDiskQuery.USER to accountInfo))
    }

    override fun updateAccount(userInfo: UserInfo): Result<UserInfo, *> {
        val params = hashMapOf(ApiConstants.FIRST_NAME to userInfo.firstName,
                ApiConstants.LAST_NAME to userInfo.lastName, ApiConstants.EMAIL to userInfo.email)
        return query(UpdateAccountApiQuery::class.java, params).map { userInfo }
    }

    override fun removeAccount() = deleteAll().map { true }
}