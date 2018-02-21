package io.github.karageageta.network

import com.karageageta.network.BuildConfig
import io.github.karageageta.network.model.response.MeResponse
import io.github.karageageta.network.model.response.WorkResponse
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Headers

interface ApiService {
    // TODO : fix
    @Headers("Authorization: bearer ${BuildConfig.ANNICT_ACCESS_TOKEN}")
    @GET("me/")
    fun getMe(): Single<MeResponse>

    @Headers("Authorization: bearer ${BuildConfig.ANNICT_ACCESS_TOKEN}")
    @GET("me/works/")
    fun getMyWorks(): Single<WorkResponse>
}