package com.news.app.models

import java.util.*
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
data class Article(@Id @GeneratedValue(strategy = GenerationType.IDENTITY) var id: Int,
              //var source: Source?,
                   var author: String?,
                   var description: String?,
                   var url: String?,
                   var urlToImage: String?,
                   var publishedAt: Date?,
                   var content: String?)