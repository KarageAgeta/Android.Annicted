package io.github.karageageta.annicted.network

import io.github.karageageta.annicted.network.response.WorkResponse
import io.reactivex.Single
import retrofit2.http.GET

interface ApiService {
    @GET("works/")
    fun getWorks(): Single<WorkResponse>
}