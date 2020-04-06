package com.news.app.repositories

import com.news.app.models.Article
import com.news.app.models.Source
import org.springframework.context.annotation.Primary
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface NewsRepository : CrudRepository<Article, String?>
