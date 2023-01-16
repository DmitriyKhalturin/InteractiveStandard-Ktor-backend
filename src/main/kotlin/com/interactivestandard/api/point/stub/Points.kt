package com.interactivestandard.api.point.stub

import com.interactivestandard.api.point.model.Point
import com.interactivestandard.api.point.response.Points

internal fun buildCustomPoints(): Points {
    val points = listOf(
        Point(1.23, 2.44),
        Point(2.17, 3.66),
        Point(3.54, 4.75),
        Point(3.21, 5.25),
        Point(4.78, 5.0),
    )

    return Points(points = points)
}
