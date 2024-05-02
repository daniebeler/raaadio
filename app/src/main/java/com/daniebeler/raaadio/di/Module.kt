package com.daniebeler.raaadio.di

import com.daniebeler.raaadio.data.remote.RadioBrowserAPI
import com.daniebeler.raaadio.data.repository.CountryRepositoryImpl
import com.daniebeler.raaadio.data.repository.StationRepositoryImpl
import com.daniebeler.raaadio.domain.repository.CountryRepository
import com.daniebeler.raaadio.domain.repository.StationRepository
import com.daniebeler.raaadio.domain.usecase.GetCountriesUseCase
import com.daniebeler.raaadio.domain.usecase.GetStationByIdUseCase
import com.daniebeler.raaadio.domain.usecase.GetStationsByLikesUseCase
import com.daniebeler.raaadio.domain.usecase.GetStationsByTagUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class Module {

    @Provides
    @Singleton
    fun provideOKHttpClient(): OkHttpClient {
        return OkHttpClient.Builder().build()
    }


    @Provides
    @Singleton
    fun provideRetrofit(client: OkHttpClient): Retrofit = Retrofit.Builder().addConverterFactory(
        GsonConverterFactory.create()
    ).client(client).baseUrl("http://de1.api.radio-browser.info/").build()

    @Provides
    @Singleton
    fun provideRadioBrowserApi(retrofit: Retrofit): RadioBrowserAPI =
        retrofit.create(RadioBrowserAPI::class.java)

    @Provides
    @Singleton
    fun provideStationRepository(
        api: RadioBrowserAPI
    ): StationRepository = StationRepositoryImpl(api)

    @Provides
    @Singleton
    fun provideCountryRepository(
        api: RadioBrowserAPI
    ): CountryRepository = CountryRepositoryImpl(api)

    @Provides
    @Singleton
    fun provideGetStationsByLikesUseCase(repository: StationRepository): GetStationsByLikesUseCase =
        GetStationsByLikesUseCase(repository)

    @Provides
    @Singleton
    fun provideGetStationUseCase(repository: StationRepository): GetStationByIdUseCase =
        GetStationByIdUseCase(repository)

    @Provides
    @Singleton
    fun provideGetStationsByTagUseCase(repository: StationRepository): GetStationsByTagUseCase =
        GetStationsByTagUseCase(repository)

    @Provides
    @Singleton
    fun provideCountriesUseCase(repository: CountryRepository): GetCountriesUseCase =
        GetCountriesUseCase(repository)
}