package uriabad.com.startapp.ui.scenes.login;

import android.content.Context
import android.content.Intent
import uriabad.com.startapp.R
import uriabad.com.startapp.ui.base.BaseActivity
import kotlinx.android.synthetic.main.activity_login.*
import org.jetbrains.anko.toast
import javax.inject.Inject


class LoginActivity : BaseActivity(), LoginView {

    companion object {
        @JvmStatic fun getIntent(context: Context): Intent {
            return Intent(context, LoginActivity::class.java)
        }
    }

    @Inject lateinit var presenter: LoginPresenter

    override var layout = R.layout.activity_login

    override fun onViewLoaded() {
        login_btn.setOnClickListener {
            navigator.navigateToAlbums(this,true)
        }
    }

    override fun onLoginSuccess(userID: String, token: String) {

        userDetails.userID = userID
        userDetails.token = token
        navigateToAlbums()
//        val navigations = listOf("Left", "Bottom")
//        selector("Which navigation you prefer?", navigations, { position ->
//            when (position) {
//                0 -> appConfig.mustUseBottomNavigation = false
//                1 -> appConfig.mustUseBottomNavigation = true
//            }
//            navigateToAlbums()
//        })

    }

    override fun onLoginError(errorMessage: String) { toast(errorMessage) }

    override fun navigateToRegister() {
        //navigator.navigateToRegister(this)
    }

    private fun navigateToAlbums() {
        navigator.navigateToAlbums(this, true)
        finish()
    }

    override fun onClearLocalDataSuccess() {

    }
}