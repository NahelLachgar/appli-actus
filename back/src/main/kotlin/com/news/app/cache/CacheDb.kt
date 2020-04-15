package com.news.app.cache

import com.news.app.models.Article
import com.news.app.models.Source
import com.news.app.repositories.NewsRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Primary
import org.springframework.data.repository.CrudRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

@Service
@Primary
class CacheDb(@Autowired var repo: NewsRepository): CustomCache<Article> {

    override fun findByArticleId(id: Int) : Article?{
        return repo.findByIdOrNull(id)
    }

    override fun updateCache(cache: Article) {
        repo.save(cache)
    }

    override fun invalidate() {
        repo.deleteAll()
    }
}