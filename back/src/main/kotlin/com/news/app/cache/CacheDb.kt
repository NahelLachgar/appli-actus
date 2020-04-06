package com.news.app.cache

import com.news.app.repositories.NewsRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Primary
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Service

@Service
@Primary
class CacheDb<Any>(@Autowired var repo: NewsRepository): CustomCache<Any> {
    override val cache: MutableIterable<kotlin.Any>
        get() = repo.findAll()

    override fun updateCache(cache: Any) {
        repo.save(cache)
    }

    override fun invalidate() {
        repo.deleteAll()
    }
}