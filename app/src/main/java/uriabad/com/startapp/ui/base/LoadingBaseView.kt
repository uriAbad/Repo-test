package uriabad.com.startapp.ui.base

import android.view.View
import uriabad.com.startapp.ui.utils.extensions.setGone
import uriabad.com.startapp.ui.utils.extensions.setInvisible
import uriabad.com.startapp.ui.utils.extensions.setVisible

interface LoadingBaseView {
    fun onLoading(infoView: View?, progressView : View?) {
        infoView?.setInvisible()
        progressView?.setVisible()
    }
    fun onInfoRetrieved(infoView: View?, progressView : View?) {
        infoView?.setVisible()
        progressView?.setGone()
    }
}