package com.mobicatz.mobicatz.domain

import com.mobicatz.mobicatz.data.dto.CardsData
import com.mobicatz.mobicatz.data.repository.MobicaApiRepository
import retrofit2.Response

class GetMobicaApiUseCase(val repository: MobicaApiRepository) :
    UseCase<Unit, Response<CardsData>>() {

    override suspend fun operation(params: Unit): Response<CardsData> {
        val response = repository.getCards()
        return response
    }
}