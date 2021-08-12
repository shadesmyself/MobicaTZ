package com.mobicatz.mobicatz.domain

import java.io.IOException

abstract class UseCase<in P, out T> {

    @Throws(IOException::class)
    protected abstract suspend fun operation(params: P): T

    suspend fun execute(params: P): T = operation(params)
}