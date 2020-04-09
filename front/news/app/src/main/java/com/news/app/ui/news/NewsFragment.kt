package com.news.app.ui.news

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.ListAdapter
import com.fasterxml.jackson.databind.DeserializationFeature
import com.fasterxml.jackson.databind.ObjectMapper
import com.news.app.R
import com.news.app.models.Article
import com.news.app.models.Articles
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
            /*val textView: TextView = root.findViewById(R.id.text_news)
        newsViewModel.text.observe(this, Observer {
            textView.text = it
        })*/
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

    val article1 = Article(0, Source(id=0, name="BFMERDE"),"Auteur","Description","URL", content = "Contenu de l'article");
    val article2 = Article(1, Source(id=1, name="L'ÉQUIPE"),"Auteur","Description","URL", content = "Contenu de l'article")
    var articles = listOf<Article>(article1, article2);

    fun getNews() {
        Log.i("getNews", "GET")

        val client = OkHttpClient()
        val request: Request = Request.Builder()
            .url("http://192.168.0.37:8080/api/news")
            .build()
        client.newCall(request).enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                Log.e("getNews", e.message)
            }

            @Throws(IOException::class)
            override fun onResponse(call: Call, response: Response) {
                Log.i("getNews", response.body?.string())
                val mapper = ObjectMapper()
                mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
                val result: Articles = mapper.readValue<Articles>(
                    response.body?.byteStream(),
                    Articles::class.java
                )
                articles = result.articles;
            }
        })
    }

}