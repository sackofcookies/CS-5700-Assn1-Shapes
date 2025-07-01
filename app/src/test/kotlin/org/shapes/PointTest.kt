package org.shapes

import kotlin.test.Test
import kotlin.test.assertNotNull
import kotlin.test.assertFails
import kotlin.test.assertEquals

class PointTest {
    @Test fun creation(){
        assertFails {
            Point(Double.POSITIVE_INFINITY, 0.0)
        }
        assertFails {
            Point(Double.NEGATIVE_INFINITY, 0.0)
        }
        assertFails {
            Point(Double.NaN, 0.0)
        }
        assertFails {
            Point(0.0, Double.POSITIVE_INFINITY)
        }
        assertFails {
            Point(0.0, Double.NEGATIVE_INFINITY)
        }
        assertFails {
            Point(0.0, Double.NaN)
        }

        
    }

    @Test fun move(){
        val point = Point(0.0, 0.0)

        point.move(0.0, 5.0)
        assertEquals(5.0, point.y)
        assertEquals(0.0, point.x)
        point.move(5.0, 0.0)
        assertEquals(5.0, point.x)
        assertEquals(5.0, point.y)
        point.move(-5.0, -5.0)
        assertEquals(0.0, point.x)
        assertEquals(0.0, point.y)

       
        assertFails {
            point.move(Double.POSITIVE_INFINITY, 0.0)
        }
        assertFails {
            point.move(Double.NEGATIVE_INFINITY, 0.0)
        }
        assertFails {
            point.move(Double.NaN, 0.0)
        }
        assertFails {
            point.move(0.0, Double.POSITIVE_INFINITY)
        }
        assertFails {
            point.move(0.0, Double.NEGATIVE_INFINITY)
        }
        assertFails {
            point.move(0.0, Double.NaN)
        }        
    }

    @Test fun clone() {
        val point = Point(0.0, 0.0)
        val pointClone = point.clone()
        assertEquals(point.x, pointClone.x)
        assertEquals(point.y, pointClone.y)
    }
}