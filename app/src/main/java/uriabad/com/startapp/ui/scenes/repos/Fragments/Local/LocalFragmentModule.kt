package uriabad.com.startapp.ui.scenes.repos.Fragments.Local

import dagger.Module
import dagger.Provides

@Module
class LocalFragmentModule {

    @Provides
    internal fun provideLocalFragmentView(localFragment: LocalFragment): LocalFragmentView {
        return localFragment
    }
}