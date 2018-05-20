package uriabad.com.startapp.interactor

import uriabad.com.startapp.Result
import uriabad.com.startapp.model.UserSummaryInfo
import uriabad.com.startapp.repository.RegisterRepository
import javax.inject.Inject

class RegisterInteractor @Inject constructor(val repository: RegisterRepository)
    : Interactor<UserSummaryInfo, HashMap<String, Any>>() {

    override fun run(params: HashMap<String, Any>): Result<UserSummaryInfo, *> {
        return repository.register(params)
    }
}