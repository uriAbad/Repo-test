package uriabad.com.startapp.ui.scenes.splash;

interface SplashView {
    fun onUserLogged(userID: String, token: String)
    fun onUserNotLogged()
}