package uriabad.com.startapp.ui.scenes.splash;


import dagger.Module
import dagger.Provides


@Module
class SplashActivityModule {
    @Provides
    internal fun provideSplashActivityView(splashActivity: SplashActivity): SplashView {
        return splashActivity
    }
}