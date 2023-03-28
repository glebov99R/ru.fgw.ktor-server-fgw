package ru.fgw.model

import kotlinx.serialization.Serializable

@Serializable
data class Test(
    val text: String
)

@Serializable
data class TestD(
    val textD: MutableList<String>
)
