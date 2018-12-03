package com.yanuwar.xampleproject

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.yanuwar.xampleproject.retrofit.ApiInterface
import com.yanuwar.xampleproject.retrofit.RetrofitClientInstance
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private lateinit var service: ApiInterface
    private lateinit var callProducts: Call<ResponseBody>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //init service retrofit
        service = RetrofitClientInstance().getRetrofitInstance().create(ApiInterface::class.java)
    }

    private fun requestData (page: Int, keywords: String) {
        callProducts = service.getListProducts(page, keywords)
        callProducts.enqueue(object: Callback<ResponseBody> {
            override fun onFailure(call: Call<ResponseBody>?, t: Throwable?) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun onResponse(call: Call<ResponseBody>?, response: Response<ResponseBody>?) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

        })
    }
}
