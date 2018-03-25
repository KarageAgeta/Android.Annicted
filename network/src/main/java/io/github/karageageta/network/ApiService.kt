package io.github.karageageta.network

import android.net.Uri
import io.github.karageageta.network.model.response.AccessTokenResponse
import io.github.karageageta.network.model.response.CodeResponse
import io.github.karageageta.network.model.response.MeResponse
import io.github.karageageta.network.model.response.WorkResponse
import io.reactivex.Single
import retrofit2.http.*

interface ApiService {
    @GET("oauth/authorize")
    fun authorize(@Query("client_id") clientId: String = BuildConfig.ANNICT_CLIENT_ID,
                  @Query("response_type") responseType: String = "code",
                  @Query("redirect_uri") redirectUri: String = Uri.encode("urn:ietf:wg:oauth:2.0:oob"),
                  @Query("scope") scope: String = Uri.encode("read+write")
    ): Single<CodeResponse>

    @POST("/oauth/token")
    fun createAccessToken(
        @Field("client_id") clientId: String,
        @Field("client_secret") clientSecret: String,
        @Field("grant_type") grantType: String,
        @Field("redirect_uri") redirectUri: String,
        @Field("code") code: String
    ): Single<AccessTokenResponse>

    @Headers("Authorization: bearer ${BuildConfig.ANNICT_ACCESS_TOKEN}")
    @GET("v1/me/")
    fun getMe(): Single<MeResponse>

    @Headers("Authorization: bearer ${BuildConfig.ANNICT_ACCESS_TOKEN}")
    @GET("v1/me/works/")
    fun getMyWorks(): Single<WorkResponse>
}