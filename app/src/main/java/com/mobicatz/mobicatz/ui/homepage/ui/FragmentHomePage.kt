package com.mobicatz.mobicatz.ui.homepage.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.Text
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import com.mobicatz.mobicatz.data.dto.Card
import com.mobicatz.mobicatz.data.dto.MobicaTzRecyclerViewData
import com.mobicatz.mobicatz.data.remote.NetworkDatabaseDataSourceImpl
import com.mobicatz.mobicatz.data.repository.MobicaApiRepositoryImpl
import com.mobicatz.mobicatz.databinding.FragmentHomePageBinding
import com.mobicatz.mobicatz.ui.homepage.vm.FragmentHomePageViewModel

class FragmentHomePage : Fragment() {

    private lateinit var binding: FragmentHomePageBinding
    private lateinit var viewModel: FragmentHomePageViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        init()
        return ComposeView(requireContext()).apply {
            setContent {
                Text(text = "Hello world.")
            }
        }
    }

    private fun init() {
        val repository = MobicaApiRepositoryImpl(NetworkDatabaseDataSourceImpl(requireActivity().application))
        viewModel = FragmentHomePageViewModel(repository)
        viewModel.initViewModel()
        viewModel.responseRecyclerViewData.observe(viewLifecycleOwner, {

            Log.e("MainViewModel", "init: ${it.body()}")
        })
    }
}