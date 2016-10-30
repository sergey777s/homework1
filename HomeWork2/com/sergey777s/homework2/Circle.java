package HomeWork2.com.sergey777s.homework2;

/**
 * Created by Sergey777s on 30.10.16.
 */
public class Circle implements shape {
    private int radius;

    @Override
    public double calculateArea() {
        return Math.PI*AnyShape.getRadius()*AnyShape.getRadius();
    }

    @Override
    public double calculatePerimeter() {
        return 2*Math.PI*AnyShape.getRadius();
    }
}
