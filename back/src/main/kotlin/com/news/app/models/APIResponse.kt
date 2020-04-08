package com.news.app.models

data class APIResponse(var status: String, var totalResults: Int, var articles: List<Article>)