package uriabad.com.startapp.interactor

import uriabad.com.startapp.Result
import uriabad.com.startapp.model.UserInfo
import uriabad.com.startapp.repository.AccountRepository
import javax.inject.Inject

class UpdateAccountInteractor @Inject constructor(val repository: AccountRepository)
    : Interactor<UserInfo, UserInfo>() {

    override fun run(params: UserInfo): Result<UserInfo, *> {
        return repository.updateAccount(params)
    }
}