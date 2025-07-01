package org.shapes

import kotlin.test.Test
import kotlin.test.assertNotNull
import kotlin.test.assertFails

class PointTest {
    @Test fun creation(){
        assertFails {
            Point(Double.POSITIVE_INFINITY, 0.0)
        }
    }
}