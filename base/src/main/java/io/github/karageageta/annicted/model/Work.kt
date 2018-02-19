package io.github.karageageta.annicted.model

data class Work(
        val id: Int = 0,
        val title: String = "",
        val titleKana: String = "",
        val media: String = "",
        val mediaText: String = "",
        val seasonName: String = "",
        val seasonNameText: String = "",
        val releasedOn: String = "",
        val releasedOnAbout: String = "",
        val officialSiteUrl: String = "",
        val wikipediaUrl: String = "",
        val twitterUsername: String = "",
        val twitterHashtag: String = "",
        val malAnimeId: String = "",
        val images: Image = Image(),
        val episodesCount: String = "",
        val watchersCount: String = "",
        val reviewsCount: String = "",
        val noEpisodes: String = ""
)