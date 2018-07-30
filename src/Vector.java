
public class Vector {
	
	public double[] vector;
	public int dimension;
	
	public Vector(int dimension) {
		this.vector = new double[dimension];
		
		//checking
//		for (int i = 0; i < dimension; i++) {
//			System.out.println(this.vector[i]);
//		}
	}
	
	public Vector(double[] array, int dimension) {
		this.vector = array;
		this.dimension = dimension;
	}

	public double[] getVector() {
		return vector;
	}

	public void setVector(double[] vector) {
		this.vector = vector;
	}
	
	public int getDimension() {
		return dimension;
	}
	
	public void setDimension(int dimension) {
		this.dimension = dimension;
	}
	
}
