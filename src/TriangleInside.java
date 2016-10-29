public class TriangleInside
{
	double cSide;
	TriangleInside(int aSide, int bSide){
		System.out.print("Your shape consist of 2 triangles with first side = "+aSide+" second side= "+bSide);
		cSide=Math.sqrt(aSide*aSide+bSide*bSide);
		System.out.println(" the last side= "+ cSide);
	}
}
