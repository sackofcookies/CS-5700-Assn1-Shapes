package org.shapes


import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import kotlin.math.abs

class TriangleTest {
    @Test fun creation() {
        val p1 = Point(0.0, 0.0)
        val p2 = Point(4.0, 0.0)
        val p3 = Point(0.0, 3.0)
        val triangle = Triangle(p1, p2, p3)

        assertEquals(0.0, triangle.p1.x)
        assertEquals(0.0, triangle.p1.y)
        assertEquals(4.0, triangle.p2.x)
        assertEquals(0.0, triangle.p2.y)
        assertEquals(0.0, triangle.p3.x)
        assertEquals(3.0, triangle.p3.y)
    }

    @Test fun zeroArea() {
        val p1 = Point(0.0, 0.0)
        val p2 = Point(1.0, 1.0)
        val p3 = Point(2.0, 2.0) // Collinear points

        assertThrows<IllegalArgumentException> { Triangle(p1, p2, p3) }
    }

    @Test fun area() {
        val triangle = Triangle(Point(0.0, 0.0), Point(4.0, 0.0), Point(0.0, 3.0))
        val expectedArea = 6.0
        assertEquals(expectedArea, abs(triangle.getArea()))
    }

    @Test fun area2() {
        val triangle = Triangle(Point(0.0, 0.0), Point(0.0, 3.0), Point(4.0, 0.0))
        val expectedArea = 6.0
        assertEquals(expectedArea, abs(triangle.getArea()))
    }

    @Test fun move() {
        val triangle = Triangle(Point(0.0, 0.0), Point(4.0, 0.0), Point(0.0, 3.0))
        triangle.move(1.0, -2.0)

        assertEquals(1.0, triangle.p1.x)
        assertEquals(-2.0, triangle.p1.y)

        assertEquals(5.0, triangle.p2.x)
        assertEquals(-2.0, triangle.p2.y)

        assertEquals(1.0, triangle.p3.x)
        assertEquals(1.0, triangle.p3.y)
    }

    @Test fun moveArea() {
        val triangle = Triangle(Point(0.0, 0.0), Point(4.0, 0.0), Point(0.0, 3.0))
        val originalArea = abs(triangle.getArea())

        triangle.move(10.0, 5.0)

        assertEquals(originalArea, abs(triangle.getArea()))
    }

    @Test fun getters() {
        val triangle = Triangle(Point(0.0, 0.0), Point(4.0, 0.0), Point(0.0, 3.0))
        val p1Clone = triangle.p1
        val p2Clone = triangle.p2
        val p3Clone = triangle.p3

        // Attempt to mutate clones
        p1Clone.move(100.0, 100.0)
        p2Clone.move(100.0, 100.0)
        p3Clone.move(100.0, 100.0)

        // Original triangle points should be unchanged
        assertEquals(0.0, triangle.p1.x)
        assertEquals(0.0, triangle.p1.y)
        assertEquals(4.0, triangle.p2.x)
        assertEquals(0.0, triangle.p2.y)
        assertEquals(0.0, triangle.p3.x)
        assertEquals(3.0, triangle.p3.y)
    }
}