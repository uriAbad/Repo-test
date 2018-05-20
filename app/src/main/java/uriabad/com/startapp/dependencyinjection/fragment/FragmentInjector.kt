package uriabad.com.startapp.dependencyinjection.fragment

import uriabad.com.startapp.dependencyinjection.scope.PerFragment
import uriabad.com.startapp.ui.base.BaseFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentInjector {

    @PerFragment
    @ContributesAndroidInjector()
    abstract fun contributeBaseFragmentInjector(): BaseFragment
}