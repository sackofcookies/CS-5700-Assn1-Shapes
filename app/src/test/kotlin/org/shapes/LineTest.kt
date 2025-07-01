package org.shapes

import kotlin.test.Test
import kotlin.test.assertNotNull
import kotlin.test.assertFails
import kotlin.test.assertEquals

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
    }
}