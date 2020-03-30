package com.news.app.repositories

import com.news.app.models.Article
import org.springframework.context.annotation.Primary
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
@Primary
interface NewsRepository : CrudRepository<Any, String?>
