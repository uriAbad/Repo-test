package uriabad.com.startapp.repository.account.queries

import uriabad.com.startapp.Result
import uriabad.com.startapp.model.exceptions.NetworkException
import uriabad.com.startapp.repository.entities.UserDataEntity
import uriabad.com.startapp.repository.entities.disk.mapper.toUserDiskEntity
import uriabad.com.startapp.repository.query.Query
import com.vicpin.krealmextensions.save
import javax.inject.Inject

class SaveAccountDiskQuery @Inject constructor(): Query {

    companion object { val USER = "user" }

    override fun query(parameters: HashMap<String, *>?, queryable: Any?): Result<UserDataEntity, *> {

        parameters?.let {
            val user = parameters[USER] as UserDataEntity
            return Result.of { user.toUserDiskEntity().save()
                user
            }
        }
        return Result.Failure(NetworkException.UnprocessableEntityException("Error whilst saving your information."))
    }
}