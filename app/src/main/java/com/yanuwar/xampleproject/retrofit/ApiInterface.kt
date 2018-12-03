package com.yanuwar.xampleproject.retrofit

import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiInterface {
    @GET("/v2/products.json")
    fun getListProducts(
            @Query("page") page: Int,
            @Query("keywords") keywords: String
    ): Call<ResponseBody>
}