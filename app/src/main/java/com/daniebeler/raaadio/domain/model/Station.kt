package com.daniebeler.raaadio.domain.model


data class Station (
    val name: String?,
    val uuid: String,
    val url: String,
    val homepage: String,
    val favicon: String,
    val country: String,
    val state: String,
    val language: String,
    val tags: List<String>
)