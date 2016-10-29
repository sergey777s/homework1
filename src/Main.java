
import java.util.*;
interface shapeParameters{
	public void calculateArea(int aSide, int bSide);
	public void calculatePerimeter(int aSide,int bSide);
	
}
interface shapeCircleParameters{
	public void calculateArea();
	public void calculatePerimeter();
}
class Circle implements shapeCircleParameters{
	private int radius;
	public void setRadius(int radius){
		this.radius=radius;
	}

	
	public void calculateArea()
	{
		System.out.print("Area of circle= ");
		System.out.println(3.14159*radius*radius);
		// TODO: Implement this method
	}

	
	public void calculatePerimeter()
	{
		System.out.print("Perimeter of circle= ");
		System.out.println(2*3.1415*radius);
		// TODO: Implement this method
	}
	
}
class Square implements shapeParameters
{
	private int aSide;
	public Square(int aSide){
		this.aSide=aSide;
	}
	

	@Override
	public void calculateArea(int aSide, int bSide)
	{
		System.out.print("Area of figure = ");
		System.out.println(aSide*bSide);
	}

	@Override
	public void calculatePerimeter(int aSide, int bSide)
	{
		System.out.print("Perimeter of figure = ");
		System.out.println(aSide*2+bSide*2);
	
		TriangleInside triangleInside=new TriangleInside(aSide,bSide);
		Triangle triangle=new Triangle(aSide,bSide,(int)triangleInside.cSide);
		triangle.calculateArea(aSide,bSide,(int)triangleInside.cSide);
		triangle.calculatePerimeter(aSide,bSide,(int)triangleInside.cSide);
	}
}
class Rectangle extends Square{
	private int bSide;

	Rectangle(int aSide, int bSide){
		super(aSide);
		this.bSide=bSide;
	}

	@Override
	public void calculateArea(int aSide, int bSide)
	{
		super.calculateArea(aSide, bSide);
	}

	@Override
	public void calculatePerimeter(int aSide, int bSide)
	{
		super.calculatePerimeter(aSide, bSide);
		
		TriangleInside triangleInside=new TriangleInside(aSide,bSide);
		Triangle triangle=new Triangle(aSide,bSide,(int)triangleInside.cSide);
		triangle.calculateArea(aSide,bSide,(int)triangleInside.cSide);
		triangle.calculatePerimeter(aSide,bSide,(int)triangleInside.cSide);
		
	}
}
class Triangle extends Rectangle{
	private int cSide;
	
	Triangle(int aSide,int bSide,int cSide){
		super(aSide,bSide);
		this.cSide=cSide;
	}

	

	public void calculatePerimeter(int aSide, int bSide, int cSide)
	{
		System.out.print("Perimeter of figure = ");
		System.out.println(aSide+bSide+cSide);
	}
	

	public void calculateArea(int aSide, int bSide, int cSide)
	{
		int p=(aSide+bSide+cSide)/2;
		int s=p*(p-aSide)*(p-bSide)*(p-cSide);
	
		
		System.out.print("Area of figure = ");
		System.out.println(Math.sqrt(s));
	}}

class Result{
	public void PrintResult(Object shape){
		
	}
}

public class Main
{
	public static void main(String[] args)
	{
		enum UserChoice {
			CIRCLE, SQUARE, RECTANGLE, TRIANGLE
		}
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
				circle.setRadius(i);
				circle.calculateArea();
				circle.calculatePerimeter();
				break;
				case "SQUARE" :
					do{
						System.out.println("Input correct one side lenght of your square:");
						if(userInput.hasNextInt()){
							i=userInput.nextInt();
						}
					}while (i<=0);
					Square square=new Square(i);
					square.calculateArea(i,i);
					square.calculatePerimeter(i,i);
					
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
					rectangle.calculateArea(aSide,i);
					rectangle.calculatePerimeter(aSide,i);
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
					triangle.calculatePerimeter(aSideT,bSideT,i);
					triangle.calculateArea(aSideT,bSideT,i);
				break;
				default : error=true;
				System.out.println("wrong input!");
			}
			if(!error){
				System.out.println("Now you can calculate next shape:(for close programm type any digit");
				if(userInput.hasNextInt()){error=false;}
				else{error=true;}}
		}
		
		while (error);
		

	

	}
}
