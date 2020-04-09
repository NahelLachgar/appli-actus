package com.news.app.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.fasterxml.jackson.annotation.JsonProperty

data class Source(
    var id: String? = null,
    var name: String,
    var description: String? =null,
    var url: String? = null,
    var category:String? = null,
    var language: String? = null,
    var country: String? = null)