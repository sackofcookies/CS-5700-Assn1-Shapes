package org.shapes

import kotlin.test.Test
import kotlin.test.assertFails
import kotlin.test.assertEquals

class SquareTest() {
    @Test fun creation() {
        val p1 = Point(0.0, 0.0)
        assertFails { 
            Square(p1, 0.0)    
        }
        assertFails { 
            Square(p1, Double.POSITIVE_INFINITY)
        }
        assertFails {
            Square(p1, Double.NEGATIVE_INFINITY)
        }
        assertFails {
            Square(p1, Double.NaN)
        }
    }

    @Test fun isSquare() {
        val square = Square(Point(0.0,0.0), 5.0)
        assertEquals(25.0, square.getArea())
    }
}