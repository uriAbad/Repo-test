package uriabad.com.startapp.ui.scenes.login;

import uriabad.com.startapp.SessionData
import uriabad.com.startapp.StoreConstants
import uriabad.com.startapp.interactor.LoginInteractor
import uriabad.com.startapp.interactor.preferences.PreferencesInteractor
import uriabad.com.startapp.interactor.preferences.PreferencesInteractor.Companion.EDIT_TYPE
import uriabad.com.startapp.network.ApiConstants.Companion.PASSWORD
import uriabad.com.startapp.network.ApiConstants.Companion.USERNAME
import uriabad.com.startapp.ui.base.BasePresenter
import com.google.gson.Gson
import javax.inject.Inject


class LoginPresenter @Inject constructor(val view: LoginView,
                                         private val loginInteractor: LoginInteractor)
    : BasePresenter()
{
    fun clearUserLocalData() {
        super.clearUserLocalData(onClearSuccess = { view.onClearLocalDataSuccess() },
                                 onClearError = { view.onLoginError(it) })
    }

    fun onLoginPressed(username: String, password: String) {
        loginInteractor.execute(hashMapOf(USERNAME to username, PASSWORD to password)) {
            result -> result.success {
                val userID = it.user.id.toString()
                val bearerToken = it.bearerToken
                storeLoginDetailsOnSharedPrefs(userID, bearerToken)
            }
            result.failure {
                exception -> view.onLoginError(exception.message.toString())
            }
        }
    }

    fun onRegisterPressed() = view.navigateToRegister()

    private fun storeLoginDetailsOnSharedPrefs(userID: String, token: String){
        preferencesInteractor.execute(
                PreferencesInteractor.PreferencesBundle(
                        EDIT_TYPE.PUT,
                        StoreConstants.SESSION_DATA,
                        Gson().toJson(SessionData(userID, token)))) {
            result -> result.success { view.onLoginSuccess(userID, token) }
            result.failure { view.onLoginError(it.message.toString()) }
        }
    }
}