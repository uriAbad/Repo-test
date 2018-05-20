package uriabad.com.startapp.interactor

import uriabad.com.startapp.Result
import uriabad.com.startapp.model.LoginInfo
import uriabad.com.startapp.repository.LoginRepository
import javax.inject.Inject

class LoginInteractor @Inject constructor(val repository: LoginRepository)
    : Interactor<LoginInfo, HashMap<String, String>>() {

    override fun run(params: HashMap<String, String>): Result<LoginInfo, *> {
        return repository.login(params)
    }
}