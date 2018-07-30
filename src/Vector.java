
public class Vector {
	
	public double[] vector;
	public int dimension;
	
	//First Constructor
	public Vector(int dimension) {
		//checking
		System.out.println("Making new vector:");
		
		this.vector = new double[dimension];
		this.dimension = dimension;
		
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
			this.dimension = dimension;
			
			//checking
			for (int i = 0; i < dimension; i++)
				System.out.println("Index " +i +": " +this.vector[i]);
			System.out.println();
		}
		
	}
	
	//Vector Add
	public void add(Vector addend) {
		for (int i = 0; i < addend.dimension; i++)
			System.out.println(addend.vector[i]);
		
		for (int i = 0; i < addend.dimension; i++)
			this.vector[i] += addend.vector[i];
		
		for (int i = 0; i < addend.dimension; i++)
			System.out.println(addend.vector[i]);
	}
}
