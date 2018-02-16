package io.github.karageageta.annicted.network.response

import io.github.karageageta.annicted.model.Work

data class WorkResponse(
        val totalCount: Int = 0,
        val nextPage: Int? = null,
        val prevPage: Int? = null,
        val works: List<Work>
)
