package io.github.karageageta.database

import io.github.karageageta.database.model.data.User
import io.github.karageageta.database.model.data.Work
import io.realm.Realm
import io.realm.RealmResults
import java.util.*
import javax.inject.Inject

class RealmService @Inject constructor(private val realm: Realm) {

    fun closeRealm() {
        realm.close()
    }

    // user

    fun readUser(id: Long): User? =
            realm.where(User::class.java).equalTo("id", id).findFirst()

    fun createUser(id: Long,
                   username: String,
                   name: String,
                   registeredAt: Date,
                   description: String = "",
                   recordsCount: Int = 0,
                   followingsCount: Int = 0,
                   followersCount: Int = 0,
                   wannaWatchCount: Int = 0,
                   watchingCount: Int = 0,
                   watchedCount: Int = 0,
                   onHoldCount: Int = 0,
                   stopWatchingCount: Int = 0
    ) {
        if (readUser(id) != null) return
        realm.executeTransaction {
            realm.createObject(User::class.java, id).also {
                it.username = username
                it.name = name
                it.description = description
                it.recordsCount = recordsCount
                it.followingsCount = followingsCount
                it.followersCount = followersCount
                it.wannaWatchCount = wannaWatchCount
                it.watchingCount = watchingCount
                it.watchedCount = watchedCount
                it.onHoldCount = onHoldCount
                it.stopWatchingCount = stopWatchingCount
                it.registeredAt = registeredAt
            }.let { realm.copyToRealm(it) }
        }
    }

    // work

    fun readWorks(): RealmResults<Work> = realm.where(Work::class.java).findAll()

    fun readWork(id: Long): Work? =
            realm.where(Work::class.java).equalTo("id", id).findFirst()

    fun createWork(id: Long,
                   title: String,
                   media: String,
                   titleKana: String = "",
                   mediaText: String = "",
                   releasedOnAbout: String = "",
                   releasedOn: Date? = null
    ) {
        realm.executeTransaction {
            realm.createObject(Work::class.java, id).also {
                it.title = title
                it.titleKana = titleKana
                it.media = media
                it.mediaText = mediaText
                it.releasedOn = releasedOn
                it.releasedOnAbout = releasedOnAbout
            }.let { realm.copyToRealm(it) }
        }
    }
}