import java.util.*;
public class Driver {

	public static void main(String[] args) {
		//list 

		
		double[] a= new double[]{3,4};
		double[] b= new double[]{6,8};
	
		
		//arraylist of vectors
		
		ArrayList<Vector> vectors= new ArrayList<Vector>();
		//creating vectors

		
		Vector A = new Vector(a,2);
		Vector B= new Vector (b,2);
		
		vectors.add(A);
		vectors.add(B);

		Matrix m= new Matrix(vectors,2);
		
		
		

	}
}
