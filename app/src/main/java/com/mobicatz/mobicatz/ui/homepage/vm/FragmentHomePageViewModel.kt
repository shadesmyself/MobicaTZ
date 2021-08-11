package com.mobicatz.mobicatz.ui.homepage.vm

import androidx.lifecycle.MutableLiveData
import com.mobicatz.mobicatz.base.BaseViewModel
import com.mobicatz.mobicatz.data.dto.MobicaTzRecyclerViewData
import com.mobicatz.mobicatz.data.repository.MobicaApiRepository
import retrofit2.Response

class FragmentHomePageViewModel(private val repository: MobicaApiRepository): BaseViewModel() {

    val responseRecyclerViewData = MutableLiveData<Response<MobicaTzRecyclerViewData>>()

    fun initViewModel() {
        runOperation {
            work {
                responseRecyclerViewData.postValue(getData())
            }
        }
    }
    private suspend fun getData(): Response<MobicaTzRecyclerViewData> {
        return repository.getRequest()
    }
}