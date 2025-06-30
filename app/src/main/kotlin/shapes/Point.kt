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

    init {
        if (x == Double.POSITIVE_INFINITY || x == Double.NEGATIVE_INFINITY){
            throw IllegalArgumentException("x cannot be infinity")
        }
        if (y == Double.POSITIVE_INFINITY || y == Double.NEGATIVE_INFINITY){
            throw IllegalArgumentException("y cannot be infinity")
        }
        if (x == Double.NaN || y == Double.NaN){
            throw IllegalArgumentException("Values cannot be NaN")
        }
    }
}