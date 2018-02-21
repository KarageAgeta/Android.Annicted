package io.github.karageageta.network.model.response

import com.google.gson.annotations.SerializedName
import java.util.*

data class MeResponse(
        val id: Long = 0,
        val username: String = "",
        val name: String = "",
        val description: String = "",
        val recordsCount: Int = 0,
        val followingsCount: Int = 0,
        val followersCount: Int = 0,
        val wannaWatchCount: Int = 0,
        val watchingCount: Int = 0,
        val watchedCount: Int = 0,
        val onHoldCount: Int = 0,
        val stopWatchingCount: Int = 0,
        @SerializedName("created_at") val registeredAt: Date = Date()
)
