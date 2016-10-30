package HomeWork2.com.sergey777s.homework2;

/**
 * Created by Sergey777s on 30.10.16.
 */
public class AnyShape {
    private static int radius;
    private static int aSide;
    private static int bSide;
    private static int cSide;
    public static void setRadius(int radius){
        AnyShape.radius=radius;
    }
    public static int getRadius(){
        return radius;
    }
    public static void setAside(int aSide){
        AnyShape.aSide=aSide;
    }
    public static int getAside(){
        return aSide;
    }
    public static void setBside(int bSide){
        AnyShape.bSide=bSide;
    }
    public static int getBside(){
        return bSide;
    }
    public static void setCside(int cSide){
        AnyShape.cSide=cSide;
    }
    public static int getCside(){
        return cSide;
    }
    public static void calculateTrianglesInside(double aSide, double bSide){
        System.out.print("Your shape consist of 2 triangles with first side = "+aSide+" second side= "+bSide);
        AnyShape.setCside((int)Math.sqrt(AnyShape.getAside()*AnyShape.getAside()+AnyShape.getBside()*AnyShape.getBside()));
        System.out.println("your last side ="+AnyShape.getCside());
        Triangle triangle=new Triangle(AnyShape.getAside(),AnyShape.getBside(),AnyShape.getCside());
        System.out.println("Each triangles area is= "+triangle.calculateArea());
        System.out.println("Each triangles perimeter is= "+triangle.calculatePerimeter());
    }
}
