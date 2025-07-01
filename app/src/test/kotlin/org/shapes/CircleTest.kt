package org.shapes

import kotlin.test.Test
import kotlin.test.assertFails
import kotlin.test.assertEquals
import kotlin.math.PI

class CircleTest() {
    @Test fun isCircle(){
        val circle = Circle(Point(0.0,0.0), 2.0)
        assertEquals(4.0*kotlin.math.PI, circle.getArea())
    }
}