package com.news.app.services

import com.news.app.models.APIResponse
import com.news.app.models.Article
import com.news.app.models.Source

interface NewsService {

    fun getNews(country: String, category: String?, query: String?): APIResponse?;
    fun getSources(): List<Source>?;
    fun insertArticle(article: Article);
    fun getArticle(id: Int): Article?
}