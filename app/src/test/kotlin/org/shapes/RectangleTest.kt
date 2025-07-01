package org.shapes

import kotlin.test.Test
import kotlin.test.assertFails
import kotlin.test.assertEquals

class RectangleTest {
    @Test fun creation() {
        val p1 = Point(0.0, 0.0)
        val p2 = Point(0.0, 5.0)
        assertFails { 
            Rectangle(p1, p2)
        }
    }
    @Test fun getArea() {
        val rectangle = Rectangle(Point(0.0, 0.0), Point(2.0, 2.0))
        assertEquals(4.0, rectangle.getArea())
    }
}