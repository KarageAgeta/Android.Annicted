package io.github.karageageta.annicted.network

import io.github.karageageta.annicted.BuildConfig
import io.github.karageageta.annicted.network.response.WorkResponse
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Headers

interface ApiService {
    // TODO : fix
    @Headers("Authorization: bearer ${BuildConfig.ANNICT_ACCESS_TOKEN}")
    @GET("me/works/")
    fun getMyWorks(): Single<WorkResponse>
}