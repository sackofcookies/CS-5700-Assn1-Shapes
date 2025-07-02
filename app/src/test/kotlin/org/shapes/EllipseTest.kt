package org.shapes

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import kotlin.math.PI

class EllipseTest {

    @Test
    fun creation() {
        val ellipse = Ellipse(Point(0.0, 0.0), 3.0, 2.0)

        assertEquals(0.0, ellipse.center.x)
        assertEquals(0.0, ellipse.center.y)
        assertEquals(3.0, ellipse.r1)
        assertEquals(2.0, ellipse.r2)
    }

    @Test
    fun zeroArea() {
        assertThrows<IllegalArgumentException> { Ellipse(Point(0.0, 0.0), 0.0, 2.0) }
        assertThrows<IllegalArgumentException> { Ellipse(Point(0.0, 0.0), 3.0, 0.0) }
    }

    @Test
    fun negativeRadius() {
        assertThrows<IllegalArgumentException> { Ellipse(Point(0.0, 0.0), -3.0, 2.0) }
        assertThrows<IllegalArgumentException> { Ellipse(Point(0.0, 0.0), 3.0, -2.0) }
    }

    @Test
    fun NaNRadius() {
        assertThrows<IllegalArgumentException> { Ellipse(Point(0.0, 0.0), Double.NaN, 2.0) }
        assertThrows<IllegalArgumentException> { Ellipse(Point(0.0, 0.0), 3.0, Double.NaN) }
    }

    @Test
    fun infiniteRadius() {
        assertThrows<IllegalArgumentException> { Ellipse(Point(0.0, 0.0), Double.POSITIVE_INFINITY, 2.0) }
        assertThrows<IllegalArgumentException> { Ellipse(Point(0.0, 0.0), 3.0, Double.NEGATIVE_INFINITY) }
    }

    @Test
    fun getArea() {
        val ellipse = Ellipse(Point(0.0, 0.0), 3.0, 2.0)
        val expectedArea = PI * 3.0 * 2.0
        assertEquals(expectedArea, ellipse.getArea())
    }

    @Test
    fun move() {
        val ellipse = Ellipse(Point(1.0, 1.0), 3.0, 2.0)
        ellipse.move(2.0, 3.0)

        assertEquals(3.0, ellipse.center.x)
        assertEquals(4.0, ellipse.center.y)
    }

    @Test
    fun moveArea() {
        val ellipse = Ellipse(Point(1.0, 1.0), 3.0, 2.0)
        val originalArea = ellipse.getArea()

        ellipse.move(5.0, -4.0)

        assertEquals(originalArea, ellipse.getArea())
    }

    @Test
    fun getters() {
        val ellipse = Ellipse(Point(0.0, 0.0), 3.0, 2.0)
        val centerClone = ellipse.center

        // Attempt to mutate clone
        centerClone.move(100.0, 100.0)

        // Original ellipse center should be unchanged
        assertEquals(0.0, ellipse.center.x)
        assertEquals(0.0, ellipse.center.y)
    }
}