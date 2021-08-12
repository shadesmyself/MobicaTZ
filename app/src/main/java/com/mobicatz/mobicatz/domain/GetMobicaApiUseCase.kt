package com.mobicatz.mobicatz.domain

import com.mobicatz.mobicatz.data.dto.MobicaTzRecyclerViewData
import com.mobicatz.mobicatz.data.repository.MobicaApiRepository
import retrofit2.Response

class GetMobicaApiUseCase(val repository: MobicaApiRepository): UseCase<Unit, Response<MobicaTzRecyclerViewData>>() {

    override suspend fun operation(params: Unit): Response<MobicaTzRecyclerViewData> {
       return repository.getRequest()
    }
}