package com.news.app.cache

import com.news.app.models.Article

interface CustomCache<Any> {
    val cache: MutableIterable<kotlin.Any>
    //val cache: Article

    fun updateCache(cache: Any)
    fun invalidate()
}