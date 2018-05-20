package uriabad.com.startapp.ui.base

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import uriabad.com.startapp.ui.AppConfig
import uriabad.com.startapp.ui.Navigator
import uriabad.com.startapp.ui.UserDetails
import uriabad.com.startapp.ui.utils.ExceptionUtils
import com.evernote.android.state.StateSaver
import dagger.android.AndroidInjection
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.support.HasSupportFragmentInjector
import org.jetbrains.anko.AnkoLogger
import javax.inject.Inject

/**
 * BaseActivity
 *
 * Default Activity that must be subclassed by the rest of activities. Takes charge of application
 * scope variables and its the root of injection
 *
 */
abstract class BaseActivity: AppCompatActivity(), ErrorBaseView, NavigationBaseView, LoadingBaseView,
        EmptyBaseView, AnkoLogger, HasSupportFragmentInjector {

    companion object {
        const val DEFAULT_FRAGMENT_TAG = "DEFAULT_FRAGMENT_TAG"
    }

    @Inject lateinit var dispatchingFragmentInjector: DispatchingAndroidInjector<Fragment>
    @Inject lateinit var navigator: Navigator
    @Inject lateinit var userDetails: UserDetails
    @Inject lateinit var appConfig: AppConfig

    abstract var layout: Int

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(layout)
        StateSaver.restoreInstanceState(this, savedInstanceState)
        onViewLoaded()
    }

    abstract fun onViewLoaded()

    protected fun navigateToLogin() {
        navigator.navigateToLogin(this)
    }

    override fun showException(exceptionMessage: String) =
            ExceptionUtils.showException(findViewById(android.R.id.content), exceptionMessage)

    override fun showUnauthorizedException() =
            ExceptionUtils.showUnauthorizedException(context = this,
                    functionToExecute = { navigateToLogin()} )

    override fun showServerError() =
            ExceptionUtils.showServerError(supportFragmentManager, "Error",
                    onBackPressed = { onBackPressed() },
                    onRefreshPressed = { recreate() } )

    override fun onSaveInstanceState(outState: Bundle?) {
        super.onSaveInstanceState(outState)
        outState.let { StateSaver.saveInstanceState(this, outState!!) }
    }

    override fun supportFragmentInjector(): AndroidInjector<Fragment> {
        return dispatchingFragmentInjector
    }

    protected fun addFragment(containerViewId: Int, fragment: Fragment) {
        supportFragmentManager.beginTransaction()
                .add(containerViewId, fragment)
                .commit()
    }

    protected fun replaceFragment(containerViewId: Int, fragment: Fragment,
                                  addToBackStack: Boolean = false,
                                  fragmentTag: String = DEFAULT_FRAGMENT_TAG) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(containerViewId, fragment)
        if (addToBackStack) transaction.addToBackStack(fragmentTag)
        transaction.commit()
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}
