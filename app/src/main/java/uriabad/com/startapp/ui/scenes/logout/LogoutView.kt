package uriabad.com.startapp.ui.scenes.logout

import uriabad.com.startapp.ui.base.ErrorBaseView

interface LogoutView : ErrorBaseView {
    fun onLogoutSuccess()
    fun onLogoutError()
}