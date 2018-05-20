package uriabad.com.startapp.dependencyinjection


import dagger.Module
import dagger.Provides
import dagger.multibindings.ElementsIntoSet
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import uriabad.com.startapp.dependencyinjection.qualifier.*
import uriabad.com.startapp.network.ApiEndpoints
import uriabad.com.startapp.network.interceptors.AuthenticationInterceptor
import uriabad.com.startapp.repository.*
import uriabad.com.startapp.repository.account.AccountApiDataSource
import uriabad.com.startapp.repository.account.AccountDataRepository
import uriabad.com.startapp.repository.account.queries.GetAccountDiskQuery
import uriabad.com.startapp.repository.account.queries.SaveAccountDiskQuery
import uriabad.com.startapp.repository.account.queries.UpdateAccountApiQuery
import uriabad.com.startapp.repository.albumDetail.AlbumDetailApiDataSource
import uriabad.com.startapp.repository.albumDetail.AlbumDetailDataRepository
import uriabad.com.startapp.repository.albumDetail.queries.AlbumDetailApiQuery
import uriabad.com.startapp.repository.albums.AlbumsApiDataSource
import uriabad.com.startapp.repository.albums.AlbumsDataRepository
import uriabad.com.startapp.repository.albums.queries.AlbumsApiQuery
import uriabad.com.startapp.repository.datasource.CacheDataSource
import uriabad.com.startapp.repository.datasource.ReadableDataSource
import uriabad.com.startapp.repository.entities.*
import uriabad.com.startapp.repository.login.LoginApiDataSource
import uriabad.com.startapp.repository.login.LoginDataRepository
import uriabad.com.startapp.repository.login.queries.LoginApiQuery
import uriabad.com.startapp.repository.preferences.PreferencesDataRepository
import uriabad.com.startapp.repository.preferences.SharedPreferencesDataSource
import uriabad.com.startapp.repository.query.Query
import uriabad.com.startapp.repository.register.RegisterApiDataSource
import uriabad.com.startapp.repository.register.RegisterDataRepository
import uriabad.com.startapp.repository.register.queries.RegisterApiQuery
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
    fun providesApiLoginReadableDataSource(loginApiDataSource: LoginApiDataSource):
            ReadableDataSource<Unit, LoginDataEntity> { return loginApiDataSource }

    @Provides
    @Singleton
    @ElementsIntoSet
    @LoginApiQueries
    fun providesLoginApiQuery(loginApiQuery: LoginApiQuery): MutableSet<Query> {
        val set = LinkedHashSet<Query>()
        set.add(loginApiQuery)
        return set
    }

    @Provides
    @Singleton
    fun providesLoginDataRepository(loginDataRepository: LoginDataRepository): LoginRepository {
        return loginDataRepository
    }

    @Provides
    @Singleton
    fun providesApiRegisterReadableDataSource(registerApiDataSource: RegisterApiDataSource):
            ReadableDataSource<Unit, UserSummaryDataEntity> { return registerApiDataSource}

    @Provides
    @Singleton
    @ElementsIntoSet
    @RegisterApiQueries
    fun providesRegisterApiQuery(registerApiQuery: RegisterApiQuery): MutableSet<Query> {
        val set = LinkedHashSet<Query>()
        set.add(registerApiQuery)
        return set
    }

    @Provides
    @Singleton
    fun providesRegisterDataRepository(registerDataRepository: RegisterDataRepository):
            RegisterRepository { return registerDataRepository }


    @Provides
    @Singleton
    fun providesSharedPreferencesDataSource(sharedPreferencesDataSource: SharedPreferencesDataSource)
            : CacheDataSource<String, String>
    {
        return sharedPreferencesDataSource
    }

    @Provides
    @Singleton
    fun providesPreferencesDataRepository(preferencesDataRepository: PreferencesDataRepository)
            : PreferencesRepository {
        return preferencesDataRepository
    }

    @Provides
    @Singleton
    fun providesApiAlbumsReadableDataSource(albumsApiDataSource: AlbumsApiDataSource):
            ReadableDataSource<Unit, AlbumDataEntity> { return albumsApiDataSource }

    @Provides
    @Singleton
    @ElementsIntoSet
    @AlbumApiQueries
    fun providesAlbumApiQuery(albumsApiQuery: AlbumsApiQuery): MutableSet<Query> {
        val set = LinkedHashSet<Query>()
        set.add(albumsApiQuery)
        return set
    }

    @Provides
    @Singleton
    fun providesAlbumDataRepository(albumDataRepository: AlbumsDataRepository): AlbumsRepository {
        return albumDataRepository
    }

    @Provides
    @Singleton
    fun providesApiAlbumDetailReadableDataSource(albumDetailApiDataSource: AlbumDetailApiDataSource):
            ReadableDataSource<String, AlbumDetailDataEntity> { return albumDetailApiDataSource }

    @Provides
    @Singleton
    @ElementsIntoSet
    @AlbumDetailApiQueries
    fun providesAlbumDetailApiQuery(albumDetailApiQuery: AlbumDetailApiQuery): MutableSet<Query> {
        val set = LinkedHashSet<Query>()
        set.add(albumDetailApiQuery)
        return set
    }

    @Provides
    @Singleton
    fun providesAlbumDetailDataRepository(albumDetailDataRepository: AlbumDetailDataRepository):
            AlbumDetailRepository {
        return albumDetailDataRepository
    }


    @Provides
    @Singleton
    @ElementsIntoSet
    @AccountApiQueries
    fun provideAccountApiQuery(updateAccountApiQuery: UpdateAccountApiQuery): MutableSet<Query> {
        val set = LinkedHashSet<Query>()
        set.add(updateAccountApiQuery)
        return set
    }

    @Provides
    @Singleton
    @ElementsIntoSet
    @AccountDiskQueries
    fun providesAccountDiskQuery(accountDiskQuery: GetAccountDiskQuery,
                                 saveAccountDiskQuery: SaveAccountDiskQuery):
            MutableSet<Query> {
        val set = LinkedHashSet<Query>()
        set.add(accountDiskQuery)
        set.add(saveAccountDiskQuery)
        return set
    }

    @Provides
    @Singleton
    fun providesAccountDataRepository(accountDataRepository: AccountDataRepository)
            : AccountRepository { return accountDataRepository }

    @Provides
    @Singleton
    fun providesAccountReadableDataSource(accountApiDataSource: AccountApiDataSource):
            ReadableDataSource<Unit, UserDataEntity> { return accountApiDataSource }

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
