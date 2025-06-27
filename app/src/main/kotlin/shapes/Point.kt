class Point(x: Double, y: Double) : Shape{
    var x = x 
        private set()
    var y = y
        private set()

    fun clone(): Point = Point(x, y)

    override public fun move(deltaX: Double, deltaY: Double) {
        x += deltaX
        y += deltaY
    }
}