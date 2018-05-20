package uriabad.com.startapp.ui.scenes.login;


import dagger.Module
import dagger.Provides


@Module
class LoginActivityModule {

    @Provides
    internal fun provideLoginView(mainActivity: LoginActivity): LoginView {
        return mainActivity
    }
}
