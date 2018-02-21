package io.github.karageageta.network.model.response

import io.github.karageageta.network.model.data.Status
import io.github.karageageta.network.model.data.Work

data class WorkResponse(
        val totalCount: Int = 0,
        val nextPage: Int? = null,
        val prevPage: Int? = null,
        val works: List<Work>,
        val status: Status? = Status()
)
