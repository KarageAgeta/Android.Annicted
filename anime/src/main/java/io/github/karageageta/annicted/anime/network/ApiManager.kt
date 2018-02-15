package io.github.karageageta.annicted.anime.network

import android.content.Context
import com.google.gson.Gson
import io.github.karageageta.annicted.anime.network.response.WorkResponse
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import timber.log.Timber
import javax.inject.Inject

class ApiManager @Inject constructor(private val service: ApiService, private val context: Context, private val gson: Gson) {
    fun getWorks(): Single<WorkResponse> {
        return service.getWorks()
                .subscribeOn(Schedulers.newThread())
                .onErrorResumeNext { Single.error(onError(it)) }
                .observeOn(AndroidSchedulers.mainThread())
    }

    // private
    private fun onError(e: Throwable): Throwable {
        Timber.e(e)
        return e
    }
}