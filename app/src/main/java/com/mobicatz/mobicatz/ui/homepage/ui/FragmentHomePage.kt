package com.mobicatz.mobicatz.ui.homepage.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.mobicatz.mobicatz.data.remote.NetworkDatabaseDataSourceImpl
import com.mobicatz.mobicatz.data.repository.MobicaApiRepositoryImpl
import com.mobicatz.mobicatz.databinding.FragmentHomePageBinding
import com.mobicatz.mobicatz.ui.homepage.vm.FragmentHomePageViewModel

class FragmentHomePage : Fragment() {

    private lateinit var binding: FragmentHomePageBinding

    private lateinit var viewModel: FragmentHomePageViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentHomePageBinding.inflate(layoutInflater)
        return binding.root
    }

    private fun init() {
        val repository = MobicaApiRepositoryImpl(NetworkDatabaseDataSourceImpl(requireActivity().application))
        viewModel = FragmentHomePageViewModel(repository)
    }
}