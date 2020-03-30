package com.news.app.services

import com.news.app.models.Article
import com.news.app.models.Source

interface NewsService {
    fun getNews(country: String, category: String?, query: String?): List<Article>?;
    fun getSources(): List<Source>?;
    fun insertArticle(article: Article);
    fun getArticle(id: Int): Article
}