
public class Vector {
	
	private double[] vector;
	private int dimension;
	
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
	
	//Vector Scale
	public Vector scale(double scalar){
		System.out.println("Vector Scale:");
		
		//printing of values before scaling
		System.out.println("Before:");
		for (int i = 0; i < this.dimension; i++) {
			System.out.println(this.vector[i]);
		}
		System.out.println();
		
		for (int i = 0; i < this.dimension; i++)
			this.vector[i] *= scalar;
		
		//printing of values after scaling
		System.out.println("After");
		for (int i = 0; i < this.dimension; i++) {
			System.out.println(this.vector[i]);
		}
		System.out.println();
		
		return this;
	}
	
	//Vector Add
	public Vector add(Vector addend) {
		System.out.println("Vector Add:");
		
		//printing of values before adding
		System.out.println("Before:");
		for (int i = 0; i < addend.dimension; i++)
			System.out.println(addend.vector[i]);
		System.out.println();
		
		for (int i = 0; i < this.dimension; i++)
			this.vector[i] += addend.vector[i];
		
		//printing of values after adding
		System.out.println("After:");
		for (int i = 0; i < addend.dimension; i++)
			System.out.println(this.vector[i]);
		System.out.println();
		
		return this;
	}
	


	public double getVector(int index) {
		return vector[index];
	}
	
	public double[] getVector() {
		return vector;
	}

	public void setVector(double vector, int index) {
		this.vector[index] = vector;
	}

	public int getDimension() {
		return dimension;
	}

	public void setDimension(int dimension) {
		this.dimension = dimension;
	}
}
