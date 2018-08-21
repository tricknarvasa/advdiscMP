import java.util.*;
public class Driver {

	public static void main(String[] args) {
		//list 

		
		double[] a= new double[]{3,4};
		double[] b= new double[]{6,8};
		

		double[] c= new double[]{1,2};
		double[] d= new double[]{3,4};
	
		
		//arraylist of vectors
		
		ArrayList<Vector> vectors= new ArrayList<Vector>();
		ArrayList<Vector> vectors2= new ArrayList<Vector>();
		//creating vectors

		
		Vector A = new Vector(a,2);
		Vector B= new Vector (b,2);
		Vector C = new Vector(c,2);
		Vector D= new Vector (d,2);
		
		
		vectors.add(A);
		vectors.add(B);
		vectors2.add(C);
		vectors2.add(D);
		Matrix m= new Matrix(vectors,2);
		Matrix r= new Matrix(vectors2,2);
		Matrix x;
		x= m.times(r);
		System.out.println(x.getVectors(0).getVector(0));
		System.out.println(x.getVectors(0).getVector(1));
		System.out.println(x.getVectors(1).getVector(0));
		System.out.println(x.getVectors(1).getVector(1));
		
		
		
		
		
		

	}
}
