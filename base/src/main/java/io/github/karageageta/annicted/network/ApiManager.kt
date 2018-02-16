package io.github.karageageta.annicted.network

import android.content.Context
import io.github.karageageta.annicted.network.response.WorkResponse
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import timber.log.Timber
import javax.inject.Inject

class ApiManager @Inject constructor(private val service: ApiService, private val context: Context) {
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