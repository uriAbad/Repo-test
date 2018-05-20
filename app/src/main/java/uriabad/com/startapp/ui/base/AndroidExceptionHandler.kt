package uriabad.com.startapp.ui.base

import android.content.Context
import uriabad.com.startapp.R
import uriabad.com.startapp.dependencyinjection.qualifier.ApplicationContext
import uriabad.com.startapp.model.exceptions.NetworkException
import uriabad.com.startapp.ui.exception.ExceptionHandler
import dagger.Reusable
import java.io.FileNotFoundException
import javax.inject.Inject

@Reusable
class AndroidExceptionHandler @Inject constructor(@ApplicationContext val context: Context) : ExceptionHandler {

    override fun<T: ErrorBaseView> notifyException(view: T, exception: Exception?) {
        when (exception) {
            is NetworkException.UnauthorizedException -> view.showUnauthorizedException()
            is NetworkException.NoInternetConnection -> view.showException( context.getString(R.string.no_internet_exception))
            is NetworkException.ServerException -> view.showServerError()
            is NetworkException.UnprocessableEntityException -> view.showException(getUnprocessableEntityMessage(exception.errorMessage!!))
            is FileNotFoundException -> view.showException(context.getString(R.string.file_not_found_exception))
            else -> view.showServerError()
        }
    }

    private fun getUnprocessableEntityMessage(msg: String?) : String {
        if (msg.isNullOrBlank()) return context.getString(R.string.unprocessable_entity_exception)
        return msg!!
    }
}