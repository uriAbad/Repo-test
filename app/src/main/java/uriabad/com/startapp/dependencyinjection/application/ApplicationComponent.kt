package uriabad.com.startapp.dependencyinjection.application

import android.app.Application
import uriabad.com.startapp.BaseApplication
import uriabad.com.startapp.dependencyinjection.ActivityInjector
import uriabad.com.startapp.dependencyinjection.DataModule
import uriabad.com.startapp.dependencyinjection.fragment.FragmentInjector
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(ApplicationModule::class, AndroidInjectionModule::class,
        ActivityInjector::class, FragmentInjector::class, DataModule::class))
interface ApplicationComponent {

    fun inject(application: BaseApplication)

    @Component.Builder
    interface Builder {
        @BindsInstance fun application(application: Application): Builder
        fun build(): ApplicationComponent
    }
}