package com.mobicatz.mobicatz.ui.homepage.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import androidx.compose.ui.graphics.asImageBitmap
import android.view.ViewGroup
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.sp
import androidx.fragment.app.Fragment
import com.mobicatz.mobicatz.MyApp
import com.mobicatz.mobicatz.R
import com.mobicatz.mobicatz.databinding.FragmentHomePageBinding
import com.mobicatz.mobicatz.ui.homepage.vm.FragmentHomePageViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import javax.inject.Inject

class FragmentHomePage : Fragment() {

    @Inject
    lateinit var viewModel: FragmentHomePageViewModel
    private var binding : FragmentHomePageBinding? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        init()
        binding = FragmentHomePageBinding.inflate(layoutInflater)
        return binding!!.root
    }

    private fun init() {
        MyApp.appComponent.inject(fragment = this)

        viewModel.initViewModel()
        viewModel.responseRecyclerViewData.observe(viewLifecycleOwner, {

        })
    }
}