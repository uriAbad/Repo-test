package uriabad.com.startapp.ui.base

interface ErrorBaseView {
    fun showException(exceptionMessage: String)
    fun showUnauthorizedException()
    fun showServerError()
}
