package HomeWork2.com.sergey777s.homework2;

/**
 * Created by Sergey777s on 30.10.16.
 */
public class Rectangle implements shape {
    Rectangle(int aSide,int bSide){
        AnyShape.setAside(aSide);
        AnyShape.setBside(bSide);
    }
    @Override
    public double calculateArea() {
        return AnyShape.getAside()*AnyShape.getBside();
    }

    @Override
    public double calculatePerimeter() {
        return AnyShape.getAside()*2+AnyShape.getBside()*2;
    }
    public void calculateTrianglesInside(double aSide, double bSide){
        System.out.print("Your shape consist of 2 triangles with first side = "+aSide+" second side= "+bSide);
        AnyShape.setCside((int)Math.sqrt(AnyShape.getAside()*AnyShape.getAside()+AnyShape.getBside()*AnyShape.getBside()));
        System.out.println("your last side ="+AnyShape.getCside());
        Triangle triangle=new Triangle(AnyShape.getAside(),AnyShape.getBside(),AnyShape.getCside());
        System.out.println("Each triangles area is= "+triangle.calculateArea());
        System.out.println("Each triangles perimeter is= "+triangle.calculatePerimeter());
    }
}
