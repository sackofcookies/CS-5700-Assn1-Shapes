package org.shapes

open class Rectangle(p1: Point, p2: Point): Shape2d{
    private val _p1: Point = p1
    val p1
        get() = _p1.clone()
    private val _p2: Point = p2
    val p2
        get() = _p2.clone()

    override public fun move(deltaX: Double, deltaY: Double) {
        p1.move(deltaX, deltaY)
        p2.move(deltaX, deltaY)
    }
    override public fun getArea(): Double{
        val tempLine1  = Line(p1, Point(p2.x, p1.y))
        val tempLine2 = Line(p2, Point(p2.x, p1.y))
        return (tempLine1.getLength() * tempLine2.getLength())
    }

    init {
        if (this.getArea() == 0.0){
            throw IllegalArgumentException("Area Must Be Greater than 0")
        }
    }
}