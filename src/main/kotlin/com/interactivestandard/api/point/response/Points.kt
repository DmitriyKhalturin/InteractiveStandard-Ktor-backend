package com.interactivestandard.api.point.response

import com.interactivestandard.api.point.model.Point
import kotlinx.serialization.Serializable

@Serializable
data class Points(
    val points: List<Point>,
)
