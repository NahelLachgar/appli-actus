package com.news.app.ui.news

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.news.app.R
import com.news.app.models.Article

class ArticleViewHolder(inflater: LayoutInflater, parent: ViewGroup) :
    RecyclerView.ViewHolder(inflater.inflate(R.layout.article_layout, parent, false)) {
    private var aTitleView: TextView? = null
    private var aContentView: TextView? = null


    init {
        aTitleView = itemView.findViewById(R.id.list_title)
        aContentView = itemView.findViewById(R.id.list_description)
    }

    fun bind(article: Article) {
        aTitleView?.text = article.source?.name;
        aContentView?.text = article.content;
    }

}