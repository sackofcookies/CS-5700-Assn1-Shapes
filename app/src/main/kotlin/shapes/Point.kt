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
        if (x.isInfinite()|| y.isInfinite()){
            throw IllegalArgumentException("Values cannot be infinity")
        }
        if (x.isNaN() || y.isNaN()){
            throw IllegalArgumentException("Values cannot be NaN")
        }
    }
}