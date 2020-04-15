package com.news.app.cache

import com.news.app.models.Article

interface CustomCache<Any> {
    fun findByArticleId(id: Int): Article?
    fun updateCache(cache: Any)
    fun invalidate()
}