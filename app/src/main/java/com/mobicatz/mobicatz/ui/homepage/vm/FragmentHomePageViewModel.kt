package com.mobicatz.mobicatz.ui.homepage.vm

import androidx.lifecycle.MutableLiveData
import com.mobicatz.mobicatz.base.BaseViewModel
import com.mobicatz.mobicatz.data.dto.MobicaTzRecyclerViewData
import com.mobicatz.mobicatz.domain.GetMobicaApiUseCase
import retrofit2.Response

class FragmentHomePageViewModel(private val getMobicaApiUseCase: GetMobicaApiUseCase): BaseViewModel() {

    val responseRecyclerViewData = MutableLiveData<Response<MobicaTzRecyclerViewData>>()

    fun initViewModel() {
        runOperation {
            work {
                responseRecyclerViewData.postValue(getData())
            }
        }
    }
    private suspend fun getData(): Response<MobicaTzRecyclerViewData> {
        return getMobicaApiUseCase.execute(Unit)
    }
}