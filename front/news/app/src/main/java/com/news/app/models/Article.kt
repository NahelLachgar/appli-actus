package com.news.app.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity
data class Article(
    @PrimaryKey
    var id: Int?,
    var source: Source? = null,
    var author: String? = null,
    var description: String? = null,
    var url: String? = null,
    var urlToImage: String? = null,
    var publishedAt: Date? = null,
    var content: String? = null)