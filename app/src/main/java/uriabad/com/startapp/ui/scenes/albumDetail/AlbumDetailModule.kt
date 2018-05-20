package uriabad.com.startapp.ui.scenes.albumDetail

import android.content.Context
import uriabad.com.startapp.dependencyinjection.qualifier.ActivityContext
import uriabad.com.startapp.dependencyinjection.scope.PerActivity
import dagger.Module
import dagger.Provides

@Module
class AlbumDetailModule {

    @Provides
    internal fun provideAlbumDetailView(albumDetailActivity: AlbumDetailActivity)
            : AlbumDetailView = albumDetailActivity

    @Provides
    @PerActivity
    @ActivityContext
    internal fun providealbumDetailContext(albumDetailActivity: AlbumDetailActivity)
            : Context = albumDetailActivity
}
