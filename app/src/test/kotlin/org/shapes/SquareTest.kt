package org.shapes

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class SquareTest {

    @Test
    fun creation() {
        val square = Square(Point(1.0, 1.0), 3.0)

        assertEquals(1.0, square.p1.x)
        assertEquals(1.0, square.p1.y)
        assertEquals(4.0, square.p2.x)
        assertEquals(4.0, square.p2.y)
        assertEquals(9.0, square.getArea())
    }

    @Test
    fun creationNegative() {
        val square = Square(Point(4.0, 4.0), -3.0)

        assertEquals(4.0, square.p1.x)
        assertEquals(4.0, square.p1.y)
        assertEquals(1.0, square.p2.x)
        assertEquals(1.0, square.p2.y)
        assertEquals(9.0, square.getArea())
    }

    @Test
    fun Zeroside() {
        assertThrows<IllegalArgumentException> { Square(Point(0.0, 0.0), 0.0) }
    }

    @Test
    fun move() {
        val square = Square(Point(0.0, 0.0), 2.0)
        square.move(3.0, 4.0)

        assertEquals(3.0, square.p1.x)
        assertEquals(4.0, square.p1.y)
        assertEquals(5.0, square.p2.x)
        assertEquals(6.0, square.p2.y)
    }

    @Test
    fun moveArea() {
        val square = Square(Point(0.0, 0.0), 5.0)
        val originalArea = square.getArea()

        square.move(-10.0, 20.0)

        assertEquals(originalArea, square.getArea())
    }

    @Test
    fun getters() {
        val square = Square(Point(0.0, 0.0), 3.0)
        val p1Clone = square.p1
        val p2Clone = square.p2

        // Attempt to mutate clones
        p1Clone.move(100.0, 100.0)
        p2Clone.move(100.0, 100.0)

        // Original square points should be unchanged
        assertEquals(0.0, square.p1.x)
        assertEquals(0.0, square.p1.y)
        assertEquals(3.0, square.p2.x)
        assertEquals(3.0, square.p2.y)
    }
}