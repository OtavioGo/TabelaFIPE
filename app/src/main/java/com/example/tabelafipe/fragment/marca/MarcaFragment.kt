package com.example.tabelafipe.fragment.marca

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tabelafipe.R
import com.example.tabelafipe.repository.Repository
import com.example.tabelafipe.viewModel.MainViewModel
import com.example.tabelafipe.viewModel.MainViewModelFactory
import kotlinx.android.synthetic.main.fragment_marca.view.*

class MarcaFragment : Fragment() {

    private lateinit var viewModel: MainViewModel
    private val mainAdapter by lazy { MarcaAdapter() }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_marca, container, false)

        //RecyclerView
        val recyclerView = view.recycleview_marca
        recyclerView.adapter = mainAdapter
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        val repository = Repository()
        val viewModelFactory = MainViewModelFactory(repository)
        viewModel = ViewModelProvider(this, viewModelFactory).get(MainViewModel::class.java)

        viewModel.getMarcas()
        viewModel.myResponse.observe(viewLifecycleOwner, Observer { response ->
            if (response.isSuccessful){
                response.body()?.let { mainAdapter.setData(it) }
            }
        })

        return view
    }
}