package com.superheroes.adaptadores

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.superheroes.R
import com.superheroes.model.response.Result
import kotlinx.android.synthetic.main.item_heroe.view.*
import java.net.MalformedURLException
import java.net.URL


class AdaptadorHeroe(
    private val mContexto: Context?,
    private var result: List<Result>,
    private var mListener: AdaptadorHeroe.OnItemClickListenerHeroe):
    RecyclerView.Adapter<AdaptadorHeroe.ViewHolder>() {

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val vista = LayoutInflater.from(mContexto).inflate(R.layout.item_heroe, viewGroup, false)
        return ViewHolder(vista)
    }

    override fun getItemCount(): Int {
        if (result == null || result.isEmpty()) {
            return 0
        } else {
            return result.size
        }
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(result[position], position)
    }

    inner class ViewHolder(itemview: View) : RecyclerView.ViewHolder(itemview) {

        fun bind(modelo: Result, position: Int) {
            var urlImage = ""
            urlImage = modelo.thumbnail?.path
                .toString() + "." + modelo.thumbnail?.extension
            getImage(urlImage,itemView.imvHeroe)

            itemView.tvNombreHeroe.text = modelo.name

            itemView.setOnClickListener {
                mListener.onItemClick(modelo,adapterPosition,urlImage)
            }

        }

        fun getImage(urlImage: String,imvImage:ImageView) {
            var urlImage = urlImage
            var url: URL? = null
            urlImage = urlImage.replace("http", "https")
            try {
                url = URL(urlImage)
                Glide
                    .with(mContexto!!)
                    .load(url)
                    .centerCrop()
                    .placeholder(R.drawable.progressload)
                    .into(imvImage)
            } catch (e: MalformedURLException) {
                Log.d("st", e.toString())
            }
        }

    }
    interface OnItemClickListenerHeroe{
        fun onItemClick(modelo: Result, posicion: Int,miImg:String)
    }

}