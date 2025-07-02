package org.shapes

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith
import kotlin.math.PI

class CircleTest {

    @Test
    fun creation() {
        val circle = Circle(Point(0.0, 0.0), 2.0)
        assertEquals(4.0 * PI, circle.getArea())
    }

    @Test
    fun ZeroCreation() {
        assertFailsWith<IllegalArgumentException> {
            Circle(Point(0.0, 0.0), 0.0)
        }
    }

    @Test
    fun negativeCreation() {
        assertFailsWith<IllegalArgumentException> {
            Circle(Point(0.0, 0.0), -2.0)
        }
    }

    @Test
    fun infiniteCreation() {
        assertFailsWith<IllegalArgumentException> {
            Circle(Point(0.0, 0.0), Double.POSITIVE_INFINITY)
        }
    }

    @Test
    fun NaNCreation() {
        assertFailsWith<IllegalArgumentException> {
            Circle(Point(0.0, 0.0), Double.NaN)
        }
    }

    @Test
    fun move() {
        val circle = Circle(Point(1.0, 1.0), 2.0)
        circle.move(3.0, -4.0)

        assertEquals(4.0, circle.center.x)
        assertEquals(-3.0, circle.center.y)
    }

    @Test
    fun moveArea() {
        val circle = Circle(Point(1.0, 1.0), 2.0)
        val originalArea = circle.getArea()

        circle.move(10.0, -5.0)

        assertEquals(originalArea, circle.getArea())
    }

    @Test
    fun getters() {
        val circle = Circle(Point(0.0, 0.0), 2.0)
        val centerClone = circle.center

        // Attempt to mutate clone
        centerClone.move(100.0, 100.0)

        // Original center should remain unchanged
        assertEquals(0.0, circle.center.x)
        assertEquals(0.0, circle.center.y)
    }
}