package uriabad.com.startapp.dependencyinjection


import dagger.Module
import dagger.Provides
import dagger.multibindings.ElementsIntoSet
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import uriabad.com.startapp.dependencyinjection.qualifier.DefaultQueries
import uriabad.com.startapp.dependencyinjection.qualifier.RepoQueries
import uriabad.com.startapp.network.ApiEndpoints
import uriabad.com.startapp.network.interceptors.AuthenticationInterceptor
import uriabad.com.startapp.repository.RepoRepository
import uriabad.com.startapp.repository.datasource.CacheDataSource
import uriabad.com.startapp.repository.datasource.ReadableDataSource
import uriabad.com.startapp.repository.entities.RepoDataEntity
import uriabad.com.startapp.repository.query.Query
import uriabad.com.startapp.repository.repositories.ApiRepoQuery
import uriabad.com.startapp.repository.repositories.RepoApiDataSource
import uriabad.com.startapp.repository.repositories.RepoDataRepository
import uriabad.com.startapp.repository.repositories.RepoLocalApiDataSource
import javax.inject.Singleton


@Module
class DataModule {

    @Provides
    @ElementsIntoSet
    @Singleton
    @DefaultQueries
    fun provideDefaultQueries(): MutableSet<Query> {
        return LinkedHashSet()
    }

    @Provides
    @Singleton
    fun providesRetrofit(authenticationInterceptor: AuthenticationInterceptor): Retrofit {
        val okHttpClient = OkHttpClient.Builder()
                .addInterceptor(authenticationInterceptor)
                .build()

        return Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(ApiEndpoints.BASE_URL)
                .client(okHttpClient)
                .build()
    }

    @Provides
    @Singleton
    @ElementsIntoSet
    @RepoQueries
    fun provideRepoApiQuery(repoQuery: ApiRepoQuery): MutableSet<Query> {
        val set = LinkedHashSet<Query>()
        set.add(repoQuery)
        return set
    }

    @Provides
    @Singleton
    fun providesRepoDataRepository(repoDataRepository: RepoDataRepository)
            : RepoRepository { return repoDataRepository }

    @Provides
    @Singleton
    fun providesRepoReadableDataSource(repoApiDataSource: RepoApiDataSource):
            ReadableDataSource<Long, RepoDataEntity> { return repoApiDataSource }

    @Provides
    @Singleton
    fun providesRepodiskDataSource(repoDiskDataSource: RepoLocalApiDataSource):
            CacheDataSource<Long, RepoDataEntity> { return repoDiskDataSource }
}
