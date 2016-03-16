package chapter4;

/**
 * Created by Administrator on 2016/3/16.
 */
abstract class Figure {
    abstract double area();
}

/**
 * 圆形
 */
class Circle extends Figure {
    final double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    double area() {
        return Math.PI * (radius * radius);
    }
}

/**
 * 矩形
 */
class Rectangle extends Figure {

    final double length;
    final double width;

    public Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    @Override
    double area() {
        return 0;
    }
}

/**
 * 正方形
 */

class Square extends Rectangle {
    Square(double side) {
        super(side, side);
    }
}