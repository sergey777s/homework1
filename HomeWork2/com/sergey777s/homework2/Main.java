package HomeWork2.com.sergey777s.homework2;
import java.util.*;
import HomeWork2.com.sergey777s.homework2.*;
enum UserChoice {
    CIRCLE, SQUARE, RECTANGLE, TRIANGLE
}

public class Main {

    public static void main(String[] args){
        boolean error=false;
        do{
            error=false;
            System.out.print("Pls write your shape name (");
            for(UserChoice choice:UserChoice.values()){
                System.out.print(" "+choice+ ",");
            }
            System.out.println(" or close this programm)");
            Scanner userInput = new Scanner(System.in);
            int i=0;
            switch(userInput.next().toString().toUpperCase()){
                case "CIRCLE" :
                    Circle circle=new Circle();

                    do{
                        System.out.println("Input correct radius of your circle:");
                        if(userInput.hasNextInt()){
                            i=userInput.nextInt();
                        }
                    }while (i<1);
                    AnyShape.setRadius(i);
                    System.out.println("Curent shape area= "+circle.calculateArea());
                    System.out.println("Curent shape perimeter= "+circle.calculatePerimeter());
                    break;
                case "SQUARE" :
                    do{
                        System.out.println("Input correct one side lenght of your square:");
                        if(userInput.hasNextInt()){
                            i=userInput.nextInt();
                        }
                    }while (i<=0);
                    Square square=new Square(i);
                    System.out.println("Curent shape area= "+square.calculateArea());
                    System.out.println("Curent shape perimeter= "+square.calculatePerimeter());
                    square.calculateTrianglesInside(AnyShape.getAside(),AnyShape.getAside());

                    break;
                case "RECTANGLE" :
                    int aSide;
                    do{
                        System.out.println("Input correct first side lenght of your rectangle:");
                        if(userInput.hasNextInt()){
                            i=userInput.nextInt();
                        }
                    }while (i<=0);
                    aSide=i;
                    i=0;
                    do{
                        System.out.println("Input correct second side lenght of your rectangle:");
                        if(userInput.hasNextInt()){
                            i=userInput.nextInt();
                        }
                    }while (i<=0);
                    Rectangle rectangle=new Rectangle(aSide,i);
                    System.out.println("Curent shape area= "+rectangle.calculateArea());
                    System.out.println("Curent shape perimeter= "+rectangle.calculatePerimeter());
                    rectangle.calculateTrianglesInside(AnyShape.getAside(),AnyShape.getBside());
                    break;
                case "TRIANGLE" :
                    int aSideT;
                    int bSideT;
                    do{
                        System.out.println("Input correct first side lenght of your triangle:");
                        if(userInput.hasNextInt()){
                            i=userInput.nextInt();
                        }
                    }while (i<=0);
                    aSideT=i;
                    i=0;
                    do{
                        System.out.println("Input correct second side lenght of your triangle:");
                        if(userInput.hasNextInt()){
                            i=userInput.nextInt();
                        }
                    }while (i<=0);
                    bSideT=i;
                    i=0;
                    do{
                        System.out.println("Input correct second side lenght of your rectangle:");
                        if(userInput.hasNextInt()){
                            i=userInput.nextInt();
                        }
                    }while (i<=0);
                    Triangle triangle=new Triangle(aSideT,bSideT,i);
                    System.out.println("Curent shape perimeter= "+triangle.calculatePerimeter());
                    System.out.println("Curent shape area= "+triangle.calculateArea());
                    break;
                default : error=true;
                    System.out.println("wrong input!");
            }
            if(!error){
                System.out.println("Now you can calculate next shape:(for close programm type any digit or any word for continue");
                if(userInput.hasNextInt()){error=false;}
                else{error=true;}}
        }

        while (error);


    }
}
