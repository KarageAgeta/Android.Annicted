package io.github.karageageta.database.model.data

import io.realm.RealmObject
import io.realm.annotations.PrimaryKey
import io.realm.annotations.Required
import java.util.*

data class Work(
        @PrimaryKey var id: Long = 0,
        @Required var title: String = "",
        var titleKana: String = "",
        @Required var media: String = "",
        var mediaText: String = "",
        @Required var releasedOn: Date? = null,
        @Required var releasedOnAbout: String = "",
        @Required var createdAt: Date = Date(),
        @Required var updatedAt: Date = Date()
) : RealmObject()
