package io.github.karageageta.database.model.data

import io.realm.RealmObject
import io.realm.annotations.PrimaryKey
import io.realm.annotations.Required
import java.util.*

open class User(
        @PrimaryKey var id: Long = 0,
        @Required var username: String = "",
        @Required var name: String = "",
        var description: String = "",
        var recordsCount: Int = 0,
        var followingsCount: Int = 0,
        var followersCount: Int = 0,
        var wannaWatchCount: Int = 0,
        var watchingCount: Int = 0,
        var watchedCount: Int = 0,
        var onHoldCount: Int = 0,
        var stopWatchingCount: Int = 0,
        @Required var registeredAt: Date = Date(),
        @Required var createdAt: Date = Date(),
        @Required var updatedAt: Date = Date()
) : RealmObject()