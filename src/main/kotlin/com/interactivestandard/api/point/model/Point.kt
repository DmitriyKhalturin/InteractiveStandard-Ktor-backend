package com.interactivestandard.api.point.model

import kotlinx.serialization.Serializable

@Serializable
data class Point(
    val x: Double,
    val y: Double,
)
