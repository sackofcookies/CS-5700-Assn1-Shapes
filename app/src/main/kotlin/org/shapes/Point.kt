package org.shapes

class Point(x: Double, y: Double) : Shape{
    var x = x 
        private set
    var y = y
        private set

    fun clone(): Point = Point(x, y)

    override public fun move(deltaX: Double, deltaY: Double) {
        if (deltaX.isInfinite() || deltaY.isInfinite()){
            throw IllegalArgumentException("Values cannot be infinity")
        }
        else if (deltaX.isNaN() || deltaY.isNaN()){
            throw IllegalArgumentException("Values cannot be NaN")
        }
        else{
            x += deltaX
            y += deltaY
        }
        
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