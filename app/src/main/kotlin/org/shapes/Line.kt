package org.shapes

import kotlin.math.sqrt

class Line(p1: Point, p2: Point): Shape{
    private val _p1: Point = p1
    val p1
        get() = _p1.clone()
    private val _p2: Point = p2
    val p2
        get() = _p2.clone()

    init {
        if ((p1.x == p2.x) && (p1.y == p2.y)){
            throw IllegalArgumentException("Line Length must be greater than 0")
        }
    }

    override public fun move(deltaX: Double, deltaY: Double){
        _p1.move(deltaX, deltaY)
        _p2.move(deltaX, deltaY)
    }

    public fun getSlope(): Double = ((p2.y - p1.y)/(p2.x - p1.x))
    public fun getLength(): Double = sqrt(((p2.x - p1.x)*(p2.x - p1.x))+((p2.y - p1.y)*(p2.y - p1.y)))
}