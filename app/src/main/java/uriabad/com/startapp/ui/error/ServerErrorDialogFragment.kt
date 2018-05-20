package uriabad.com.startapp.ui.error

import android.os.Bundle
import android.support.v4.app.DialogFragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import uriabad.com.startapp.R
import uriabad.com.startapp.ui.utils.ExceptionUtils

class ServerErrorDialogFragment: DialogFragment() {

    var onToolbarBackPressed: (() -> Unit)? = null
    var onToolbarRefreshPressed: (() -> Unit)? = null

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val activityTitle = arguments.get(ExceptionUtils.ACTIVITY_TITLE) as String
        if (inflater == null) return super.onCreateView(inflater, container, savedInstanceState)
        val view = inflater.inflate(R.layout.activity_something_wrong, null, false)
//        view.toolbar.toolbar_title.text = activityTitle
//        view.toolbar.toolbar_option.text = getString(R.string.refresh)
//        view.toolbar.toolbar_option.setOnClickListener { onRefreshPressed() }
//        view.toolbar.toolbar_back.setOnClickListener { onBackPressed() }
        return view
    }

    private fun onBackPressed() {
        dismiss()
        if (onToolbarBackPressed != null) (onToolbarBackPressed!!)()
        else activity.onBackPressed()
    }
    private fun onRefreshPressed() {
        dismiss()
        if (onToolbarRefreshPressed != null) (onToolbarRefreshPressed!!)()
        else activity.onBackPressed()
    }
}