package uriabad.com.startapp.dependencyinjection

import dagger.Module
import dagger.android.ContributesAndroidInjector
import uriabad.com.startapp.dependencyinjection.scope.PerActivity
import uriabad.com.startapp.ui.scenes.repoDetail.RepoDetailActivity
import uriabad.com.startapp.ui.scenes.repoDetail.RepoDetailActivityModule
import uriabad.com.startapp.ui.scenes.repos.RepoActivity
import uriabad.com.startapp.ui.scenes.repos.RepoActivityModule
import uriabad.com.startapp.ui.scenes.splash.SplashActivity
import uriabad.com.startapp.ui.scenes.splash.SplashActivityModule

@Module
abstract class ActivityInjector {

    @PerActivity
    @ContributesAndroidInjector(modules = arrayOf(SplashActivityModule::class))
    abstract fun contributeSplashInjector(): SplashActivity

    @PerActivity
    @ContributesAndroidInjector(modules = arrayOf(RepoActivityModule::class))
    abstract fun contributerepositoryInjector(): RepoActivity

    @PerActivity
    @ContributesAndroidInjector(modules = arrayOf(RepoDetailActivityModule::class))
    abstract fun contributeRepoDetailInjector(): RepoDetailActivity

}