package uriabad.com.startapp.ui.scenes.login;

import uriabad.com.startapp.ui.base.ErrorBaseView


interface LoginView : ErrorBaseView {
    fun onLoginSuccess(userId: String, token: String)
    fun onLoginError(errorMessage: String)
    fun navigateToRegister()
    fun onClearLocalDataSuccess()
}