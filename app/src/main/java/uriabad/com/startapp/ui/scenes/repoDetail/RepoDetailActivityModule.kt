package uriabad.com.startapp.ui.scenes.repoDetail

import android.content.Context
import dagger.Module
import dagger.Provides
import uriabad.com.startapp.dependencyinjection.qualifier.ActivityContext
import uriabad.com.startapp.dependencyinjection.scope.PerActivity
import uriabad.com.startapp.ui.scenes.repos.RepoActivity
import uriabad.com.startapp.ui.scenes.repos.RepoView

@Module
class RepoDetailActivityModule {

    @Provides
    internal fun provideRepoDetailView(repoDetailActivity: RepoDetailActivity): RepoDetailView {
        return repoDetailActivity
    }

    @Provides
    @PerActivity
    @ActivityContext
    internal fun provideActivityContext(repoDetailActivity: RepoDetailActivity): Context {
        return repoDetailActivity
    }
}