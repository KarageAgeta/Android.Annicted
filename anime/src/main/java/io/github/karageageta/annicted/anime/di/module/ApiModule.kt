package io.github.karageageta.annicted.anime.di.module

import com.google.gson.Gson
import dagger.Module
import javax.inject.Singleton
import dagger.Provides
import io.github.karageageta.annicted.anime.ApplicationConfig
import io.github.karageageta.annicted.anime.network.ApiService
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

@Module
class ApiModule {
    @Provides
    @Singleton
    internal fun provideRetrofit(config: ApplicationConfig, client: OkHttpClient, gson: Gson): ApiService {
        return Retrofit.Builder()
                .baseUrl(config.apiUrl)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
                .create(ApiService::class.java)
    }
}