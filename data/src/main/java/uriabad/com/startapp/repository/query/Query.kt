package uriabad.com.startapp.repository.query

import uriabad.com.startapp.Result

interface Query {

    fun queryAll(parameters: HashMap<String, *>? = null, queryable: Any? = null): Result<Collection<*>, *> {
        return Result.Failure()
    }
    fun query(parameters: HashMap<String, *>? = null, queryable: Any? = null): Result<*, *> {
        return Result.Failure()
    }

}