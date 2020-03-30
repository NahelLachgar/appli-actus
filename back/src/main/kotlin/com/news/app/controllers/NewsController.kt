package com.news.app.controllers

import com.news.app.models.Article
import com.news.app.models.Source
import com.news.app.services.NewsService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/news")
class NewsController(@Autowired val newsService: NewsService) {

 @GetMapping()
 fun getNews(@RequestParam(name="category") category: String?, @RequestParam(name="query") query: String?): List<Article>? {
   return newsService.getNews(
           country="fr",
           category = category,
           query = query
   );
 }

    @GetMapping("/sources")
    fun getSources(): List<Source>? {
        return newsService.getSources();
    }
}