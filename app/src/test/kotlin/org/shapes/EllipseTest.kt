package org.shapes

import kotlin.test.Test
import kotlin.test.assertFails
import kotlin.test.assertEquals
import kotlin.math.PI

class EllipseTest {
    @Test fun creation() {
        val p1 = Point(0.0, 0.0)
        assertFails { 
            Ellipse(p1, 5.0, 0.0)
        }

        assertFails {
            Ellipse(p1, Double.POSITIVE_INFINITY, 1.0)
        }
        assertFails {
            Ellipse(p1, Double.NEGATIVE_INFINITY, 1.0)
        }
        assertFails {
            Ellipse(p1, Double.NaN, 1.0)
        }
        assertFails {
            Ellipse(p1, -1.0, 1.0)
        }
        assertFails {
            Ellipse(p1, 1.0, Double.POSITIVE_INFINITY)
        }
        assertFails {
            Ellipse(p1, 1.0, Double.NEGATIVE_INFINITY)
        }
        assertFails {
            Ellipse(p1, 1.0, Double.NaN)
        }
        assertFails {
            Ellipse(p1, 1.0, -1.0)
        }
    }
    @Test fun getArea() {
        val ellipse = Ellipse(Point(0.0, 0.0), 2.0, 2.0)
        assertEquals(4.0* kotlin.math.PI, ellipse.getArea())
    }
}