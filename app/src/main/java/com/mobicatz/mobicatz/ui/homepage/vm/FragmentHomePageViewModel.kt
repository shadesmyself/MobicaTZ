package com.mobicatz.mobicatz.ui.homepage.vm

import com.mobicatz.mobicatz.base.BaseViewModel
import com.mobicatz.mobicatz.data.dto.ResponseRecyclerViewData
import com.mobicatz.mobicatz.data.repository.MobicaApiRepository
import retrofit2.Call

class FragmentHomePageViewModel(private val repository: MobicaApiRepository): BaseViewModel() {

    fun initViewModel() {
        runOperation {
            work {
                getData()
            }
        }
    }
    private suspend fun getData(): Call<ResponseRecyclerViewData> {
        return repository.getRequest()
    }
}