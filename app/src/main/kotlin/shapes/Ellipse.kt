open class Ellipse(center: Point, r1: Double, r2: Double): Shape2d {
    private val _center: Point = center
    val center
        get() = _center.clone()
    var r1 = r1 
        private set()
    var r2 = r2
        private set()

    override public fun move(deltaX: Double, deltaY: Double) = center.move(deltaX, deltaY)

    override public fun getArea(): Double = (kotlin.math.PI * r1 * r2)

    init {
        if (this.getArea() == 0.0){
            throw IllegalArgumentException("Area Must Be Greater than 0")
        }
    }
}