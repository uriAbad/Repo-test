package uriabad.com.startapp.ui.scenes.albums;


import android.content.Context
import uriabad.com.startapp.dependencyinjection.qualifier.ActivityContext
import uriabad.com.startapp.dependencyinjection.scope.PerActivity
import dagger.Module
import dagger.Provides


@Module
class AlbumsActivityModule {

    @Provides
    internal fun provideAlbumsView(albumsActivity: AlbumsActivity): AlbumsView {
        return albumsActivity
    }

    @Provides
    @PerActivity
    @ActivityContext
    internal fun provideActivityContext(albumsActivity: AlbumsActivity): Context {
        return albumsActivity
    }
}
