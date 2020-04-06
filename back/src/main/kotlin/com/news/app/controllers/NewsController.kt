package com.news.app.controllers

import com.news.app.models.Article
import com.news.app.models.Source
import com.news.app.repositories.NewsRepository
import com.news.app.services.NewsService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/news")
class NewsController(@Autowired val newsService: NewsService, @Autowired val newsRepository: NewsRepository ) {

     @GetMapping()
     fun getNews(@RequestParam(name="category") category: String?, @RequestParam(name="query") query: String?): List<Article>? {
       return newsService.getNews(
               country="fr",
               category = category,
               query = query
       );
     }

    @GetMapping("/article")
    fun getArticle(@RequestParam(name="id") id: Int): Article {
        return newsService.getArticle(id);
    }

    @GetMapping("/sources")
    fun getSources(): List<Source>? {
        return newsService.getSources();
    }

    @GetMapping("/insertArticle")
    fun insertArticle() {
        var article = Article( id =0, author ="test", description ="test" , url ="test", urlToImage ="test", publishedAt =null, content ="test" )
        newsService.insertArticle(article);
    }

    @GetMapping("/article/{id}")
    fun getArticle(@PathVariable(name="id") id: Int): MutableIterable<Article> {
        return newsService.getArticle(id)
    }
}