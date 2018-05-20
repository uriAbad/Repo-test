package uriabad.com.startapp.ui

import android.content.Context
import android.content.Intent
import android.support.v4.app.ActivityOptionsCompat
import android.support.v4.util.Pair
import android.support.v7.app.AppCompatActivity
import android.view.View
import uriabad.com.startapp.ui.entities.AlbumViewEntity
import uriabad.com.startapp.ui.scenes.albumDetail.AlbumDetailActivity
import uriabad.com.startapp.ui.scenes.repos.RepoActivity
import uriabad.com.startapp.ui.scenes.login.LoginActivity
import javax.inject.Inject

/**
 * Navigator
 *
 * Class to route between activities
 *
 * @constructor Creates an [Navigator].
 */
class Navigator @Inject constructor() {

    fun navigateToLogin(context: Context) {
        val intent = LoginActivity.getIntent(context)
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK)
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        context.startActivity(intent)
    }

    fun navigateToAlbums(context: Context, clearTask: Boolean) {
        if (context !is RepoActivity) {
            val intent = RepoActivity.getIntent(context)
            if (clearTask) {
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK)
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            }
            context.startActivity(intent)
        }
    }

    fun navigateToAlbumDetail(activity: AppCompatActivity, albumInfo: AlbumViewEntity,
                              transitionObjects: ArrayList<Pair<View, String>>? = null) {
        val intent = AlbumDetailActivity.getIntent(activity, albumInfo)
        var options : ActivityOptionsCompat?
        transitionObjects?.let {
            options = ActivityOptionsCompat.makeSceneTransitionAnimation(activity,
                    *transitionObjects.toTypedArray())
            activity.startActivity(intent, options?.toBundle())
            return
        }
        activity.startActivity(intent)
    }
}
