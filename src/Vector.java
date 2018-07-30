
public class Vector {
	
	public double[] vector;
	public int dimension;
	
	//First Constructor
	public Vector(int dimension) {
		//checking
		System.out.println("Making new vector:");
		
		this.vector = new double[dimension];
		
		//checking
		for (int i = 0; i < dimension; i++)
			System.out.println("Index " +i +": " +this.vector[i]);
		System.out.println();
	}
	
	//Second Constructor
	public Vector(double[] array, int dimension) {
		if (array.length != dimension)
			System.out.println("array and dimension mismatch.");
		else {
			//checking
			System.out.println("Making new vector:");
			
			this.vector = array;
			
			//checking
			for (int i = 0; i < dimension; i++)
				System.out.println("Index " +i +": " +this.vector[i]);
			System.out.println();
		}
		
	}

}
