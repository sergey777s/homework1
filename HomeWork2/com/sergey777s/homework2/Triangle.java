package HomeWork2.com.sergey777s.homework2;

/**
 * Created by Sergey777s on 30.10.16.
 */
public class Triangle implements shape {
    Triangle(int aSide, int bSide, int cSide){
        AnyShape.setAside(aSide);
        AnyShape.setBside(bSide);
        AnyShape.setCside(cSide);
    }
    @Override
    public double calculateArea() {
        double p=calculatePerimeter()/2;
        return Math.sqrt(p*(p-AnyShape.getAside())*(p-AnyShape.getBside())*(p-AnyShape.getCside()));
    }

    @Override
    public double calculatePerimeter() {
        return AnyShape.getAside()+AnyShape.getBside()+AnyShape.getCside();
    }
}
