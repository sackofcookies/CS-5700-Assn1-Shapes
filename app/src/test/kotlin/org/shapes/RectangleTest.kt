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
        val p3 = Point(4.0, 3.0)
        val rectangle = Rectangle(p1, p3)

        assertEquals(0.0, rectangle.p1.x)
        assertEquals(0.0, rectangle.p1.y)
        assertEquals(4.0, rectangle.p2.x)
        assertEquals(3.0, rectangle.p2.y)
    }
    @Test fun getArea() {
        val rectangle = Rectangle(Point(0.0, 0.0), Point(2.0, 2.0))
        assertEquals(4.0, rectangle.getArea())
        val rectangle2 = Rectangle(Point(-2.0, -3.0), Point(2.0, 1.0))
        assertEquals(16.0, rectangle2.getArea())
        val rectangle3 = Rectangle(Point(0.0, 0.0), Point(5.0, 3.0))
        val originalArea = rectangle3.getArea()

        rectangle3.move(10.0, 5.0)

        assertEquals(originalArea, rectangle3.getArea())
    }
    @Test fun getters() {
        val rectangle = Rectangle(Point(0.0, 0.0), Point(4.0, 3.0))
        val p1Clone = rectangle.p1
        val p2Clone = rectangle.p2

        p1Clone.move(100.0, 100.0)
        p2Clone.move(100.0, 100.0)

        assertEquals(0.0, rectangle.p1.x)
        assertEquals(0.0, rectangle.p1.y)
        assertEquals(4.0, rectangle.p2.x)
        assertEquals(3.0, rectangle.p2.y)
    }
}