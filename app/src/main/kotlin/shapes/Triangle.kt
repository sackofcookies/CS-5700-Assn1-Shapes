class Triangle(p1: Point, p2: Point, p3: Point): Shape2d {
    var p1 = p1
        get() = p1.clone()
    var p2 = p2
        get() = p2.clone()
    var p3 = p3
        get() = p3.clone()

    override public fun move(deltaX: Double, deltaY: Double){
        p1.move(deltaX, deltaY)
        p2.move(deltaX, deltaY)
        p3.move(deltaX, deltaY)
    }   

    override public fun getArea(): Double = (((p2.x - p1.x) * (p3.y - p1.y)) - ((p3.x - p1.x) * (p2.y - p1.y))) / 2
}