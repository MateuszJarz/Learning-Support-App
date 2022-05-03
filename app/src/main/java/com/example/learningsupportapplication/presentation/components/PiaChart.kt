package com.example.learningsupportapplication.presentation.components

import android.widget.Toast
import androidx.compose.animation.core.FloatTweenSpec
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.translate
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlin.math.atan2

@Composable
fun PiaChart(
    modifier: Modifier = Modifier,
    goodAnswers: Int,
    badAnswers: Int,
) {
    val context = LocalContext.current
    val points = listOf(goodAnswers.toFloat(), badAnswers.toFloat())
    val color = listOf(
        Color.Blue,
        Color.Red
    )
    val sum = points.sum()
    var startAngle = 0f
    val radius = 350f
    val rect = Rect(Offset(-radius, -radius), Size(2 * radius, 2 * radius))
    val path = Path()

    val angles = mutableListOf<Float>()

    var start by remember { mutableStateOf(false) }
    val sweepPre by animateFloatAsState(
        targetValue = if (start) 1f else 0f,
        animationSpec = FloatTweenSpec(duration = 1000)
    )

    if (sum == 0.0F) {
        Toast
            .makeText(context, "zero $points", Toast.LENGTH_SHORT)
            .show()
    } else {
        Canvas(
            modifier = Modifier
                .fillMaxWidth()
               .padding(start = 32.dp)
                .height(350.dp)
                .pointerInput(Unit) {
                    detectTapGestures(
                        onTap = {
                            val x = it.x - radius
                            val y = it.y - radius
                            var touchAngle = Math.toDegrees(atan2(y.toDouble(), x.toDouble()))
                            if (x < 0 && y < 0 || x > 0 && y < 0) {
                                touchAngle += 360
                            }
                            val position =
                                getPositionFromAngle(touchAngle = touchAngle, angles = angles)
                            Toast
                                .makeText(context, "onTap: $points", Toast.LENGTH_SHORT)
                                .show()
                        }
                    )


                },

            ) {
            translate(radius, radius) {
                start = true
                for ((i, p) in points.withIndex()) {

                    val sweepAngle = p / sum * 360f
                    path.moveTo(0f, 0f)
                    path.arcTo(
                        rect = rect,
                        startAngleDegrees = startAngle,
                        sweepAngleDegrees = sweepAngle * sweepPre,
                        false
                    )
                    angles.add(sweepAngle)
                    drawPath(path = path, color = color[i])
                    path.reset()
                    startAngle += sweepAngle
                }
            }
        }

    }
}

private fun getPositionFromAngle(
    angles: List<Float>,
    touchAngle: Double
): Int {
    var totalAngle = 0f
    for ((i, angle) in angles.withIndex()) {
        totalAngle += angle
        if (touchAngle <= totalAngle) {
            return i
        }
    }
    return -1
}

