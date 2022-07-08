package com.example.countries.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.countries.model.CountryModel
import com.example.countries.R
import com.example.countries.view.MainActivity
import kotlinx.android.synthetic.main.country_list_recycler.view.*

class CountryAdapter(countryModel: CountryModel) : RecyclerView.Adapter<CountryAdapter.MyViewHolder>() {

    private var countriesList: List<CountryModel>? = null
    private var countriesListed: List<CountryModel>? = null
    private var context: Context? = null

    inner class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val countryName : TextView = itemView.findViewById(R.id.countryName)
        val code : TextView = itemView.findViewById(R.id.code)
        val currencyCode : TextView = itemView.findViewById(R.id.currencyCodes)
        val wiki : TextView = itemView.findViewById(R.id.wiki)

    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountryAdapter.MyViewHolder {
        return MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.country_list_recycler,parent,false))
    }

    override fun onBindViewHolder(holder: CountryAdapter.MyViewHolder, position: Int) {
        val countries : CountryModel = countriesListed!![position]
        holder.countryName.text = countries.name
        holder.code.text = countries.code
        holder.wiki.text = countries.wikiDataId
        holder.currencyCode.text = countries.currencyCodes.toString()
    }

    override fun getItemCount(): Int {
        return if (countriesList != null) {
            countriesListed!!.size
        } else {
            0
        }
    }


}