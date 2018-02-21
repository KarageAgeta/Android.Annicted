package io.github.karageageta.network

import android.content.Context
import io.github.karageageta.network.model.response.MeResponse
import io.github.karageageta.network.model.response.WorkResponse
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import timber.log.Timber
import javax.inject.Inject

class ApiManager @Inject constructor(private val service: ApiService, private val context: Context) {
    fun getMe(): Single<MeResponse> =
            service.getMe()
                    .subscribeOn(Schedulers.newThread())
                    .onErrorResumeNext { Single.error(onError(it)) }
                    .observeOn(AndroidSchedulers.mainThread())

    fun getMyWorks(): Single<WorkResponse> =
            service.getMyWorks()
                    .subscribeOn(Schedulers.newThread())
                    .onErrorResumeNext { Single.error(onError(it)) }
                    .observeOn(AndroidSchedulers.mainThread())

    // private
    private fun onError(e: Throwable): Throwable {
        Timber.e(e)
        return e
    }
}