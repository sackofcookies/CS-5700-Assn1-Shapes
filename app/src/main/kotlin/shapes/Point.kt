class Point(var x: Double, var y: Double) : Shape{
    fun clone(): Point = Point(x, y)

    override fun move(deltaX: Double, deltaY: Double) {
        x += deltaX
        y += deltaY
    }
}