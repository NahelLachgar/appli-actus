package com.news.app.services

import com.fasterxml.jackson.databind.DeserializationFeature
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.news.app.models.APIResponse
import com.news.app.models.Article
import com.news.app.models.Source
import com.news.app.models.Sources
import com.news.app.repositories.NewsRepository
import okhttp3.Headers
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Primary
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import java.io.IOException

@Service
@Primary
class NewsServiceImpl(
        private val newsRepository: NewsRepository, @Value("\${newsToken}") private val apiToken: String
) : NewsService {
    fun apiCall(url: String, headers: Headers? = null): Response? {
        val client = OkHttpClient();
        val request = Request.Builder()
                .url(url)
                .build();
        try {
            val response: Response = client.newCall(request).execute();
            return response;
        }
        catch(e: IOException) {
            e.printStackTrace();
            return null;
        }
    }

    override fun getNews(country: String, category: String?, query: String?): List<Article>? {
        var url = "http://newsapi.org/v2/top-headlines?country=$country";
        if (query != null) url+= "&q=$query";
        if (category != null) url+="&category=$category";
        url+= "&apiKey=$apiToken";
        val response = apiCall(url);
        try {
            val mapper = jacksonObjectMapper();
            mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            val res = mapper.readValue(response?.body?.byteStream(), APIResponse::class.java);
            return res.articles;
        }
        catch(e: Exception)  {
            e.printStackTrace();
            return null;
        }
    }

    override fun getSources(): List<Source>? {
        var url = "https://newsapi.org/v2/sources?apiKey=$apiToken";
        val response = apiCall(url);
         try {
            val mapper = jacksonObjectMapper();
            mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            val res = mapper.readValue(response?.body?.byteStream(), Sources::class.java);
            return res.sources;
        }
        catch(e: Exception)  {
            e.printStackTrace();
            return null;
        }
    }

    override fun insertArticle(article: Article) {
        newsRepository.save(article)
    }

    override fun getArticle(id: Int): Article? {
        return newsRepository.findByIdOrNull(id)

    }

}