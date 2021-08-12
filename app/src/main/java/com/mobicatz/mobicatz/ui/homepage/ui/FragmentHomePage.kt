package com.mobicatz.mobicatz.ui.homepage.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.sp
import androidx.fragment.app.Fragment
import com.mobicatz.mobicatz.MyApp
import com.mobicatz.mobicatz.ui.homepage.vm.FragmentHomePageViewModel
import javax.inject.Inject

class FragmentHomePage : Fragment() {
    @Inject
    lateinit var viewModel: FragmentHomePageViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        init()
        return ComposeView(requireContext()).apply {
            setContent {
                LazyColumnDemo()
            }
        }
    }

    private fun init() {
        MyApp.appComponent.inject(fragment = this)

        viewModel.initViewModel()
        viewModel.responseRecyclerViewData.observe(viewLifecycleOwner, {

        })
    }
    @Composable
    fun LazyColumnDemo() {
        val list = listOf(
            "A", "B", "C", "D"
        ) + ((0..100).map { it.toString() })
        LazyColumn(modifier = Modifier.fillMaxSize()) {
            items(items = list, itemContent = { item ->
                Log.d("COMPOSE", "This get rendered $item")
                when (item) {
                    "A" -> {
                        Text(text = item, style = TextStyle(fontSize = 80.sp))
                    }
                    "B" -> {
                        Button(onClick = {}) {
                            Text(text = item, style = TextStyle(fontSize = 80.sp))
                        }
                    }
                    "C" -> {
                        //Do Nothing
                    }
                    "D" -> {
                        Text(text = item)
                    }
                    else -> {
                        Text(text = item, style = TextStyle(fontSize = 80.sp))
                    }
                }
            })
        }
    }
}