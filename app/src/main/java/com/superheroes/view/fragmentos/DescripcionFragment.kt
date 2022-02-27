package com.superheroes.view.fragmentos

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.google.gson.Gson
import com.superheroes.R
import com.superheroes.retrofit.repositorio.Repositorio
import com.superheroes.utilidades.Coroutines
import com.superheroes.viewmodel.ViewModel
import kotlinx.android.synthetic.main.fragment_descripcion.*
import java.net.MalformedURLException
import java.net.URL

class DescripcionFragment : Fragment() {

    private var vista: View? = null
    private var viewmodel:ViewModel? = null
    private var repositorio: Repositorio? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        vista = inflater.inflate(R.layout.fragment_descripcion, container, false)
        viewmodel = ViewModelProvider(this).get(ViewModel::class.java)
        return vista
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        repositorio = Repositorio()
        tvNombreHeroeSelected.text = arguments?.getString("nombre")
        tvDescripHeroeSelected.text = arguments?.getString("descripcion")
        getImage(arguments?.getString("image").toString())

    }

    fun getImage(urlImage: String) {
        var urlImage = urlImage
        var url: URL? = null
        urlImage = urlImage.replace("http", "https")
        try {
            url = URL(urlImage)
            Glide
                .with(context!!)
                .load(url)
                .centerCrop()
                .placeholder(R.drawable.progressload)
                .into(imvHeroeSelected)
        } catch (e: MalformedURLException) {
            Log.d("Error", e.toString())
        }
    }

}