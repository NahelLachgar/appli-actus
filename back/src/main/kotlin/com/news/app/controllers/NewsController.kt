package com.news.app.controllers

import com.news.app.models.APIResponse
import com.news.app.models.Article
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/news")
class NewsController {
 @GetMapping()
 fun getNews(): List<Article> {

 }
}