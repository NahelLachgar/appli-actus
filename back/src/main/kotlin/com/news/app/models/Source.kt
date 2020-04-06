package com.news.app.models

import javax.persistence.Entity

class Source(var id: String?,
             var name: String,
             var description: String?,
             var url: String?,
             var category:String?,
             var language: String?,
             var country: String?)