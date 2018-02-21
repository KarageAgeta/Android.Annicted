package io.github.karageageta.database.di

import android.content.Context
import dagger.Module
import dagger.Provides
import io.github.karageageta.database.RealmService
import io.realm.Realm
import javax.inject.Singleton

@Module
class DatabaseModule {
    @Provides
    @Singleton
    fun provideRealm(context: Context): Realm {
        Realm.init(context)
        return Realm.getDefaultInstance()
    }

    @Provides
    @Singleton
    fun provideRealmService(realm: Realm): RealmService {
        return RealmService(realm)
    }
}

