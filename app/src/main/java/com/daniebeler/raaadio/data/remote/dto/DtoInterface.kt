package com.daniebeler.raaadio.data.remote.dto

interface DtoInterface<T> {
    fun toModel(): T
}