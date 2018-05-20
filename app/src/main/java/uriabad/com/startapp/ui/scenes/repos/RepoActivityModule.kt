package uriabad.com.startapp.ui.scenes.repos;


import android.content.Context
import dagger.Module
import dagger.Provides
import uriabad.com.startapp.dependencyinjection.qualifier.ActivityContext
import uriabad.com.startapp.dependencyinjection.scope.PerActivity


@Module
class RepoActivityModule {

    @Provides
    internal fun provideAlbumsView(repoActivity: RepoActivity): RepoView {
        return repoActivity
    }

    @Provides
    @PerActivity
    @ActivityContext
    internal fun provideActivityContext(repoActivity: RepoActivity): Context {
        return repoActivity
    }
}
