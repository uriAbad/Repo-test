package uriabad.com.startapp.ui.base

import android.view.View
import uriabad.com.startapp.ui.utils.extensions.setGone
import uriabad.com.startapp.ui.utils.extensions.setVisible

interface EmptyBaseView {

    fun showEmptyView(emptyView: View?, infoView: View?) {
        emptyView?.setVisible()
        infoView?.setGone()
    }

    fun hideEmptyView(emptyView: View?, infoView : View?) {
        emptyView?.setGone()
        infoView?.setVisible()
    }
}