import java.util.*;
public class Driver {

	public static void main(String[] args) {
		//list 
		double[] a= new double[]{1,1,2};
		double[] b= new double[]{3,-2,1};
		double[] c= new double[]{1,-1,2};
		double[] d= new double[]{10,-6,10};


	
		
		//arraylist of vectors
		ArrayList<Vector> vectors= new ArrayList<Vector>();
		//creating vectors
		Vector A = new Vector(a,3);
		Vector B= new Vector (b,3);
		Vector C= new Vector(c,3);
		Vector D= new Vector(d,3);
		
		//Vector that will contain solution for Gauss Jordan
		Vector Solution= new Vector(3);
		//Adding Vectors in List arrangement below:
		// [1 3  1]
		// [1 -2 2]
		// [2 1  2]
		vectors.add(A);
		vectors.add(B);
		vectors.add(C);
		//vectors.add(D);
		//Vector D will contain constants, arrangement below
		// [1 3  1][10]
		// [1 -2 2][-6]
		// [2 1  2][10]
	Solution=Solution.Gauss_Jordan(vectors, 3, D);
//		
	Solution.printVector();
		Matrix m= new Matrix(vectors,3);
		System.out.println("determinant is:"+ m.det());
	}
}
