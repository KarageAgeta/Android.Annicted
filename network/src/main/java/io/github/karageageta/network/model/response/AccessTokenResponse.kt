package io.github.karageageta.network.model.response

data class AccessTokenResponse(
    val accessToken: String = "",
    val tokenType: String = "",
    val scope: String = "",
    val createdAt: Int = 0
)
