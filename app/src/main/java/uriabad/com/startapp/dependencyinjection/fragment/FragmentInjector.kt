package uriabad.com.startapp.dependencyinjection.fragment

import dagger.Module
import dagger.android.ContributesAndroidInjector
import uriabad.com.startapp.dependencyinjection.scope.PerFragment
import uriabad.com.startapp.ui.base.BaseFragment
import uriabad.com.startapp.ui.scenes.repos.Fragments.Explore.ExploreFragment
import uriabad.com.startapp.ui.scenes.repos.Fragments.Explore.ExploreFragmentModule
import uriabad.com.startapp.ui.scenes.repos.Fragments.Local.LocalFragment
import uriabad.com.startapp.ui.scenes.repos.Fragments.Local.LocalFragmentModule

@Module
abstract class FragmentInjector {

    @PerFragment
    @ContributesAndroidInjector()
    abstract fun contributeBaseFragmentInjector(): BaseFragment

    @PerFragment
    @ContributesAndroidInjector(modules = [(ExploreFragmentModule::class)])
    abstract fun contributeExploreFragmentInjector(): ExploreFragment

    @PerFragment
    @ContributesAndroidInjector(modules = [(LocalFragmentModule::class)])
    abstract fun contributeLocalFragmentInjector(): LocalFragment
}