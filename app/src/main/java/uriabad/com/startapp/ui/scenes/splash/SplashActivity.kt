package uriabad.com.startapp.ui.scenes.splash;

import android.os.Handler
import uriabad.com.startapp.R
import uriabad.com.startapp.ui.base.BaseActivity
import javax.inject.Inject

class SplashActivity: BaseActivity(), SplashView {

    companion object {
        private val SPLASH_DELAY_MS: Long = 500
        private val handler: Handler = Handler()
    }

    @Inject lateinit var presenter: SplashPresenter
    override var layout = R.layout.activity_splash
    override fun onViewLoaded() {
        navigator.toRepos(this,true)
    }


    override fun showUnauthorizedException() {}

    override fun showServerError() { }

}