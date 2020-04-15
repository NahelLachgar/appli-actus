package com.news.app.ui.news

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.fasterxml.jackson.databind.DeserializationFeature
import com.fasterxml.jackson.databind.ObjectMapper
import com.news.app.R
import com.news.app.models.APIResponse
import com.news.app.models.Article
import com.news.app.models.Source
import kotlinx.android.synthetic.main.fragment_news.*
import okhttp3.*
import java.io.IOException

class NewsFragment : Fragment() {

    private lateinit var newsViewModel: NewsViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        getNews();

        newsViewModel =
            ViewModelProviders.of(this).get(NewsViewModel::class.java)
            val root = inflater.inflate(R.layout.fragment_news, container, false)
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // RecyclerView node initialized here
        list_recycler_view.apply {
            // set a LinearLayoutManager to handle Android
            // RecyclerView behavior
            layoutManager = LinearLayoutManager(activity)
            // set the custom adapter to the RecyclerView
            adapter = ListAdapter(articles)
        }
    }

    companion object {
        fun newInstance(): NewsFragment = NewsFragment()
    }

    val article1 = Article(id=0, source=Source(name="Source"),author = "Auteur", description = "Description",url="URL", content = "Contenu de l'article");
    val article2 = Article(id=1, source=Source(name="Source"),author = "Auteur", description = "Description",url="URL", content = "Contenu de l'article");
    var articles = listOf<Article>(article1, article2);

    fun getNews() {
        Log.i("getNews", "GET")

        val client = OkHttpClient()
        val request: Request = Request.Builder()
            .url("http://ec2-35-180-30-108.eu-west-3.compute.amazonaws.com:8080/api/news")
            .build()
        client.newCall(request).enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                Log.e("getNews", e.message)
            }

            @Throws(IOException::class)
            override fun onResponse(call: Call, response: Response) {
                val mapper = ObjectMapper()
                mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
                val result: APIResponse = mapper.readValue<APIResponse>(
                    response.body?.byteStream(),
                    APIResponse::class.java
                )
                articles = result.articles;
            }
        })
    }

}