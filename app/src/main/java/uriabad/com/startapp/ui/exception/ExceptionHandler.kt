package uriabad.com.startapp.ui.exception

import uriabad.com.startapp.ui.base.ErrorBaseView

interface ExceptionHandler {
    fun <T : ErrorBaseView> notifyException(view: T, exception: Exception?)
}