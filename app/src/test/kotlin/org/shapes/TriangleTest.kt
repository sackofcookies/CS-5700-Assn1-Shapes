package org.shapes

import kotlin.test.Test
import kotlin.test.assertFails
import kotlin.test.assertEquals

class TriangleTest {
    @Test fun creation() {
        val p1 = Point(0.0, 0.0)
        val p2 = Point(5.0, 0.0)
        val p3 = Point(-5.0, 0.0)
        assertFails { 
            Triangle(p1, p2, p3)
        }
    }
    @Test fun getArea() {
        val triangle = Triangle(Point(0.0, 0.0), Point(2.0, 0.0), Point(0.0, 2.0))
        assertEquals(2.0, triangle.getArea())
    }
}