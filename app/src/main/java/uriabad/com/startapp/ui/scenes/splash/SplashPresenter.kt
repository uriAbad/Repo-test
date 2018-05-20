package uriabad.com.startapp.ui.scenes.splash;

import uriabad.com.startapp.SessionData
import uriabad.com.startapp.StoreConstants
import uriabad.com.startapp.interactor.preferences.PreferencesInteractor
import com.google.gson.Gson
import javax.inject.Inject


class SplashPresenter @Inject constructor(val view: SplashView,
                                          private val preferencesInteractor: PreferencesInteractor) {

    fun isUserStored(){
        preferencesInteractor.execute(
                PreferencesInteractor.PreferencesBundle(
                        PreferencesInteractor.Companion.EDIT_TYPE.GET,
                        StoreConstants.SESSION_DATA )) {
            result -> result.success {
                val sessionData = Gson().fromJson(it, SessionData::class.java)
                val userId = sessionData.userID
                val token = sessionData.token
                view.onUserLogged(userId , token)
            }
            result.failure {
                view.onUserNotLogged()
            }
        }
    }
}