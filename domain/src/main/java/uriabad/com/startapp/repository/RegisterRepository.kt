package uriabad.com.startapp.repository

import uriabad.com.startapp.Result
import uriabad.com.startapp.model.UserSummaryInfo

interface RegisterRepository {
    fun register(params: HashMap<String, Any>): Result<UserSummaryInfo, *>
}