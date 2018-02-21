package io.github.karageageta.network.di

import com.google.gson.FieldNamingPolicy
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import io.github.karageageta.network.ApiService
import io.github.karageageta.network.NetworkConfig
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class ApiModule {
    @Provides
    @Singleton
    fun provideGson(): Gson =
            GsonBuilder()
                    .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                    .create()

    @Provides
    @Singleton
    fun provideOkhttpClient(): OkHttpClient =
            OkHttpClient.Builder()
                    .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
                    .build()

    @Provides
    @Singleton
    fun provideNetworkConfig(): NetworkConfig = NetworkConfig()

    @Provides
    @Singleton
    internal fun provideApiService(config: NetworkConfig, client: OkHttpClient, gson: Gson): ApiService =
            Retrofit.Builder()
                    .baseUrl(config.apiUrl)
                    .client(client)
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .build()
                    .create(ApiService::class.java)
}
