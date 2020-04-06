package com.news.app.cache

interface CustomCache<Any> {
    val cache: MutableIterable<kotlin.Any>

    fun updateCache(cache: Any)
    fun invalidate()
}