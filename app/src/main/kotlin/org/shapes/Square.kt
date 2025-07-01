package org.shapes

//p1 is the bottom left point if sideLength is positive and is the top right point if sideLength is negative
class Square(p1: Point, sideLength: Double): Rectangle(p1, Point(p1.x + sideLength, p1.y + sideLength))