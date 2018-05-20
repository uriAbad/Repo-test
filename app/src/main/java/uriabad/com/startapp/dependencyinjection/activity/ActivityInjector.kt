package uriabad.com.startapp.dependencyinjection

import uriabad.com.startapp.dependencyinjection.scope.PerActivity
import uriabad.com.startapp.ui.scenes.albumDetail.AlbumDetailActivity
import uriabad.com.startapp.ui.scenes.albumDetail.AlbumDetailModule
import uriabad.com.startapp.ui.scenes.albums.AlbumsActivity
import uriabad.com.startapp.ui.scenes.albums.AlbumsActivityModule
import uriabad.com.startapp.ui.scenes.login.LoginActivity
import uriabad.com.startapp.ui.scenes.login.LoginActivityModule
import uriabad.com.startapp.ui.scenes.splash.SplashActivity
import uriabad.com.startapp.ui.scenes.splash.SplashActivityModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityInjector {

    @PerActivity
    @ContributesAndroidInjector(modules = arrayOf(SplashActivityModule::class))
    abstract fun contributeSplashInjector(): SplashActivity

    @PerActivity
    @ContributesAndroidInjector(modules = arrayOf(LoginActivityModule::class))
    abstract fun contributeLoginInjector(): LoginActivity

    @PerActivity
    @ContributesAndroidInjector(modules = arrayOf(AlbumsActivityModule::class))
    abstract fun contributeAlbumsInjector(): AlbumsActivity

    @PerActivity
    @ContributesAndroidInjector(modules = arrayOf(AlbumDetailModule::class))
    abstract fun contributeAlbumDetailInjector(): AlbumDetailActivity

}