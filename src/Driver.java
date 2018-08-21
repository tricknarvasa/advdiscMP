import java.util.*;
public class Driver {

	public static void main(String[] args) {
		//list 
//		double[] a= new double[]{1,1,4,1};
//		double[] b= new double[]{2,2,10,6};
//		double[] c= new double[]{3,9,21,17};
//		double[] d= new double[]{5,11,29,23};
//		double[] e= new double[]{1,5,2,3};
		
//		double[] a= new double[]{1,3,1};
//		double[] b= new double[]{1,-2,-1};
//		double[] c= new double[]{2,1,2};
//		double[] d= new double[]{10,-6,10};
		
		double[] a= new double[]{3,4};
		double[] b= new double[]{6,8};
	
		
		//arraylist of vectors
		ArrayList<Vector> vectors= new ArrayList<Vector>();
		//creating vectors
//		Vector A = new Vector(a,4);
//		Vector B= new Vector (b,4);
//		Vector C= new Vector(c,4);
//		Vector D= new Vector(d,4);
//		Vector E= new Vector(e,4);
		
		Vector A = new Vector(a,2);
		Vector B= new Vector (b,2);
//		Vector C= new Vector(c,4);
//		Vector D= new Vector(d,4);
		//Vector that will contain solution for Gauss Jordan
		Vector Solution= new Vector(2);
		//Adding Vectors in List arrangement below:
		// [1 3  1]
		// [1 -2 -1]
		// [2 1  2]
		vectors.add(A);
		vectors.add(B);
//		vectors.add(C);
//		vectors.add(D);
		//Vector D will contain constants, arrangement below
		// [1 3  1][10]
		// [1 -2 2][-6]
		// [2 1  2][10]
		
	
		//Solution.printVector();
		Matrix m= new Matrix(vectors,2);
		
		m.transpose();
		

	}
}
