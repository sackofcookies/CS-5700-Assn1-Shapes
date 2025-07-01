package org.shapes

class Triangle(p1: Point, p2: Point, p3: Point): Shape2d {
    private val _p1 = p1
    val p1
        get() = _p1.clone()
    private val _p2 = p2
    val p2
        get() = _p2.clone()
    private val _p3 = p3
    val p3
        get() = _p3.clone()


    override public fun move(deltaX: Double, deltaY: Double){
        p1.move(deltaX, deltaY)
        p2.move(deltaX, deltaY)
        p3.move(deltaX, deltaY)
    }   

    override public fun getArea(): Double = (((p2.x - p1.x) * (p3.y - p1.y)) - ((p3.x - p1.x) * (p2.y - p1.y))) / 2

    init {
        if (this.getArea() == 0.0){
            throw IllegalArgumentException("Area Must Be Greater than 0")
        }
    }
}