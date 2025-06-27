import kotlin.math.sqrt
import kotlin.math.pow

class Line(p1: Point, p2: Point): Shape{
    var p1: Point = p1
        get() = p1.clone()
    var p2: Point = p2
        get() = p2.clone()

    override public fun move(deltaX: Double, deltaY: Double){
        p1.move(deltaX, deltaY)
        p2.move(deltaX, deltaY)
    }

    public fun getSlope(): Double = ((p2.y - p1.y)/(p2.x - p1.x))
    public fun getLength(): Double = sqrt(((p2.x - p1.x)*(p2.x - p1.x))+((p2.y - p1.y)*(p2.y - p1.y)))
}