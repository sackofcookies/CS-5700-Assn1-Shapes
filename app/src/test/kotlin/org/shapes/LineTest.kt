package org.shapes

import kotlin.test.Test
import kotlin.test.assertFails
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class LineTest {
    @Test fun creation() {
        val p1 = Point(0.0, 0.0)
        val p2 = Point(0.0, 0.0)
        assertFails { 
            Line(p1, p2)    
        }
    }

    @Test fun move(){
        val line = Line(Point(0.0, 0.0), Point(5.0, 5.0))
        line.move(5.0, 0.0)
        assertEquals(5.0, line.p1.x)
        assertEquals(10.0, line.p2.x)
        assertEquals(0.0, line.p1.y)
        assertEquals(5.0, line.p2.y)
        line.move(0.0, 5.0)
        assertEquals(5.0, line.p1.x)
        assertEquals(10.0, line.p2.x)
        assertEquals(5.0, line.p1.y)
        assertEquals(10.0, line.p2.y)
        line.move(-5.0, -5.0)
        assertEquals(0.0, line.p1.x)
        assertEquals(5.0, line.p2.x)
        assertEquals(0.0, line.p1.y)
        assertEquals(5.0, line.p2.y)

        val line2 = Line(Point(0.0, 0.0), Point(3.0, 4.0))
        val originalSlope = line2.getSlope()
        val originalLength = line2.getLength()

        line2.move(10.0, -5.0)

        assertEquals(originalSlope, line2.getSlope())
        assertEquals(originalLength, line2.getLength())
    }

    @Test fun getLength() {
        val line = Line(Point(0.0, 0.0), Point(3.0, 4.0))
        assertEquals(5.0, line.getLength())
    }
    @Test fun getSlope() {
        val line = Line(Point(0.0, 0.0), Point(1.0, 2.0))
        assertEquals(2.0, line.getSlope())

        val line2 = Line(Point(2.0, 1.0), Point(2.0, 5.0))
        assertTrue(line2.getSlope().isInfinite())
    }


    @Test fun `moved line keeps correct slope and length`() {
        
    }

    @Test fun getters() {
        val line = Line(Point(0.0, 0.0), Point(1.0, 1.0))
        val p1Clone = line.p1
        val p2Clone = line.p2

        p1Clone.move(100.0, 100.0)
        p2Clone.move(100.0, 100.0)

        assertEquals(0.0, line.p1.x)
        assertEquals(0.0, line.p1.y)
        assertEquals(1.0, line.p2.x)
        assertEquals(1.0, line.p2.y)
    }
}