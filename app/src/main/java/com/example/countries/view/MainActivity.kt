package com.example.countries.view


import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.AttributeSet
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.countries.R
import com.example.countries.adapter.CountryAdapter

import com.example.countries.databinding.ActivityMainBinding
import com.example.countries.model.CountryModel
import com.google.gson.GsonBuilder

import kotlinx.android.synthetic.main.activity_main.*
import okhttp3.*
import java.io.IOException


class MainActivity : AppCompatActivity() {


    private lateinit var binding: ActivityMainBinding


    private lateinit var countryRecycler: RecyclerView

    private var countryAdapter: CountryAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        countryRecycler = findViewById<RecyclerView>(R.id.countryRecycler)
        countryRecycler.layoutManager = LinearLayoutManager(this)
        countryRecycler.adapter=countryAdapter

        textView.setOnClickListener {
            getData()
        }

       bottomNavigation.setOnNavigationItemSelectedListener { it ->
            when(it.itemId){
                R.id.home -> {
                    val intent = Intent(this,MainActivity::class.java)
                    startActivity(intent)
                }
                R.id.saved -> {
                    val intent = Intent(this,SavedCountry::class.java)
                    startActivity(intent)
                }
            }
            true
        }
    }

    override fun onCreateView(name: String, context: Context, attrs: AttributeSet): View? {
        return super.onCreateView(name, context, attrs)

    }
    fun getData() {
        try {
            val client = OkHttpClient()
            var countryList = ArrayList<CountryModel>()
            val request = Request.Builder()
                .url("https://wft-geo-db.p.rapidapi.com/v1/geo/countries")
                .get()
                .addHeader(
                    "X-RapidAPI-Key",
                    "0d061639f6msh4ce49e8b1f003d0p1e863ajsnbdc18ddffe45"
                )
                .addHeader("X-RapidAPI-Host", "wft-geo-db.p.rapidapi.com")
                .build()

            client.newCall(request).enqueue(object : Callback {
                override fun onFailure(call: Call, e: IOException) {
                    println(e)
                }

                override fun onResponse(call: Call, response: Response) {
                    val body2 = response.body!!.string()
                    println("deneme : $body2")

                    val gson = GsonBuilder().create()

                    val homeFeed = gson.fromJson(body2, CountryModel::class.java)
                    runOnUiThread() {
                        countryRecycler.adapter = CountryAdapter(homeFeed)
                    }

                }
                //Log.i("test",body)

        })
    } catch (e: Exception) {
        println(e)
    }
}
}



