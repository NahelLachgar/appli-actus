package com.news.app.models

class APIResponse(var status: String, var totalResults: Int, var articles: List<Article>)