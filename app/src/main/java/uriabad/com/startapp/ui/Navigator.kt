package uriabad.com.startapp.ui

import android.content.Context
import android.content.Intent
import uriabad.com.startapp.ui.entities.RepoViewEntity
import uriabad.com.startapp.ui.scenes.repoDetail.RepoDetailActivity
import uriabad.com.startapp.ui.scenes.repos.RepoActivity
import javax.inject.Inject

/**
 * Navigator
 *
 * Class to route between activities
 *
 * @constructor Creates an [Navigator].
 */
class Navigator @Inject constructor() {

    fun toRepos(context: Context, clearTask: Boolean) {
        val intent = RepoActivity.getIntent(context)
        if (clearTask) {
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK)
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        }
        context.startActivity(intent)
    }

    fun toRepoDetail(context: Context, repo: RepoViewEntity) {
        val intent = RepoDetailActivity.getIntent(context, repo)
        context.startActivity(intent)
    }
}
