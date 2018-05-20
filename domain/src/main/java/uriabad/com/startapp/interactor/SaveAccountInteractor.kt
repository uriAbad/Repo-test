package uriabad.com.startapp.interactor

import uriabad.com.startapp.Result
import uriabad.com.startapp.model.UserInfo
import uriabad.com.startapp.repository.AccountRepository
import javax.inject.Inject

class SaveAccountInteractor @Inject constructor(val repository: AccountRepository)
    : Interactor<UserInfo, Unit>() {

    override fun run(params: Unit): Result<UserInfo, *> {
        return repository.getStoredAccount()
    }
}