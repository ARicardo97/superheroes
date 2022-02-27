package com.superheroes.view.fragmentos

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.Gson
import com.superheroes.R
import com.superheroes.adaptadores.AdaptadorHeroe
import com.superheroes.retrofit.repositorio.Repositorio
import com.superheroes.model.response.Result
import com.superheroes.utilidades.Coroutines
import com.superheroes.viewmodel.ViewModel
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment() {

    private var vista: View? = null
    private var repositorio: Repositorio? = null
    private var viewmodel:ViewModel? = null

    private var recyHeroe: RecyclerView? = null
    private var adaptadorHero: AdaptadorHeroe? = null
    private var laymanHeroe: RecyclerView.LayoutManager? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        vista = inflater.inflate(R.layout.fragment_home, container, false)
        viewmodel = ViewModelProvider(this).get(ViewModel::class.java)
        return vista
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyHeroe = vista?.findViewById(R.id.recyclerHeroes)
        repositorio = Repositorio()
        getCharacters()
    }

    fun listaHeroes(data: List<Result>){
        recyHeroe!!.setHasFixedSize(true)
        laymanHeroe = GridLayoutManager(context, 2)
        recyHeroe!!.layoutManager = laymanHeroe

        adaptadorHero = AdaptadorHeroe(context, data,
            object : AdaptadorHeroe.OnItemClickListenerHeroe {
                override fun onItemClick(modelo: Result, posicion: Int, miImg: String) {
                    var bundle = bundleOf(
                        "nombre" to modelo.name,
                        "descripcion" to modelo.description,
                        "image" to miImg)
                    modelo.series?.items
                    findNavController().popBackStack(R.id.nav_descripcion,true)
                    findNavController().navigate(R.id.nav_descripcion,bundle)
                }

            })
        recyHeroe!!.adapter = adaptadorHero
    }

    private fun getCharacters() = Coroutines.main {
        try {
            progresbar.visibility = View.VISIBLE
            viewmodel?.getCharacters().also { response ->
                if (response?.isSuccessful == true){
                    var list = response.body()!!.data!!.results
                    progresbar.visibility = View.GONE
                    if (list != null) {
                        listaHeroes(list)
                    }
                    list?.forEachIndexed { index, data ->
                        //Log.e("st","data ${Gson().toJson(data.series?.items)}")
                    }
                }
            }
        }catch (e:Exception){
            Log.e("st",e.message.toString())
        }
    }

}