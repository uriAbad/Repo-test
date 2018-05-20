package uriabad.com.startapp.ui.scenes.repos.Fragments.Explore

import dagger.Module
import dagger.Provides

@Module
class ExploreFragmentModule {

    @Provides
    internal fun provideExploreFragmentView(exploreFragment: ExploreFragment): ExploreFragmentView {
        return exploreFragment
    }
}