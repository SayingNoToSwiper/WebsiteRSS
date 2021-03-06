package com.damiengo.websiterss.article.json

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface Api {

    @GET("/api/v1/efr/news/{article_id}")
    suspend fun getItems(@Path("article_id") articleId: String): Response<ItemList>

}