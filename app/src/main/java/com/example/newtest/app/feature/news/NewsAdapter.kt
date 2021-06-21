package com.example.newtest.app.feature.news

import android.content.Context
import android.content.Entity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.newtest.R
import com.example.newtest.data.model.NewsEntity
import com.example.newtest.data.model.NewsItem
import com.example.newtest.data.model.NewsModel
import com.example.newtest.data.model1.MovieMode
import com.example.newtest.data.model1.ProductionCompany
import kotlinx.android.synthetic.main.movi_item.view.*
import kotlinx.android.synthetic.main.news_item.view.*


class NewsAdapter(context: Context, private val action: (ProductionCompany) -> Unit) :
    RecyclerView.Adapter<NewsAdapter.ViewHolder>(), Filterable{
    private var myList = mutableListOf<ProductionCompany>()
    private val inflater = LayoutInflater.from(context)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = inflater.inflate(R.layout.movi_item, parent, false)
        return ViewHolder(view, action)
    }

    override fun getItemCount(): Int {
        return myList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.onBind(myList[position])
    }


    fun updateNews(newList: List<ProductionCompany>) {
        myList.clear()
        myList.addAll(newList)
        this.notifyDataSetChanged()
    }

    fun setProvidedPrice(newPrice: Int) {
//        price = newPrice;
        notifyDataSetChanged()
    }

    class ViewHolder(contienerView: View, private val action: (ProductionCompany) -> Unit) :
        RecyclerView.ViewHolder(contienerView) {
        private var selectSubject: ProductionCompany? = null

        fun onBind(newsItem: ProductionCompany) {
            this.selectSubject = newsItem

            itemView.apply {
                setOnClickListener { action.invoke(selectSubject!!) }

                Glide.with(itemView)
                    .load(
                            newsItem.logoPath

                    )
                    .centerCrop()
                    .error(R.drawable.newss)
                    .into(iv_news_item_image)
                tv_film_name.text = newsItem.name
                tv_film_about.text = newsItem.originCountry
            }

        }

    }

    override fun getFilter(): Filter {
        return object : Filter() {
            override fun performFiltering(constraint: CharSequence?): FilterResults {
                val charSearch = constraint.toString()
                if (charSearch.isEmpty()) {
                    myList = myList as ArrayList<ProductionCompany>
                } else {
                    val resultList = ArrayList<ProductionCompany>()
                    for (row in myList) {
                        if (row.name!!.toLowerCase().contains(constraint.toString().toLowerCase())) {
                            resultList.add(row)
                        }
                    }
                    myList = resultList
                }
                val filterResults = FilterResults()
                filterResults.values = myList
                return filterResults
            }

            override fun publishResults(constraint: CharSequence?, results: FilterResults?) {
                myList = results?.values as ArrayList<ProductionCompany>
                notifyDataSetChanged()
            }
        }
    }

}