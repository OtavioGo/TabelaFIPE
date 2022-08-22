package com.example.tabelafipe.fragment.modelo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tabelafipe.R
import com.example.tabelafipe.repository.Repository
import com.example.tabelafipe.viewModel.MainViewModel
import com.example.tabelafipe.viewModel.MainViewModelFactory
import kotlinx.android.synthetic.main.fragment_modelo.view.*

class ModeloFragment : Fragment() {

    private val args by navArgs<ModeloFragmentArgs>()

    private lateinit var viewModel: MainViewModel
    private val modeloAdapter by lazy { ModeloAdapter() }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_modelo, container, false)

        //RecyclerView
        val recyclerView = view.recycleview_modelo
        recyclerView.adapter = modeloAdapter
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        val repository = Repository()
        val viewModelFactory = MainViewModelFactory(repository)
        viewModel = ViewModelProvider(this, viewModelFactory).get(MainViewModel::class.java)

        val codigo = args.currentUser.codigo

        viewModel.getModelos(codigo)
        viewModel.myResponse2.observe(viewLifecycleOwner, Observer { response ->
            if (response.isSuccessful){
                response.body()?.let { modeloAdapter.setData(it) }
            }
        })

        return view
    }


}