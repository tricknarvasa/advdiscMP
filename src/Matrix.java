import java.util.ArrayList;

public class Matrix {

	private ArrayList<Vector> Vectors;
	private int dimension;
	
	//First Constructor
	public Matrix(int dimension) {
		this.Vectors = new ArrayList<>();
		this.dimension = dimension;
	}
	
	//Second Constructor
	public Matrix(ArrayList<Vector> list, int dimension) {
		//error checking
		if (list.size() != dimension) {
			System.out.println("Size of list and dimension mismatch");
		}
		else {
			//initializing Vectors ArrayList
			this.Vectors = new ArrayList<>();
			
			//transfers list to Vectors
			for (int i = 0; i < list.size(); i++) {
				Vectors.add(list.get(i));
			}

			this.dimension = dimension;
		}
		
	}
	
	//Matrix multiplication
	public Matrix times(Matrix other) {
		//TODO this function
		
		//error checking
		if (this.dimension != other.getDimension()) {
			System.out.println("Matrix size mismatch");
		}
		else {
			for (int i = 0; i < this.dimension; i++) {
				//TODO Change if necessary
				for (int j = 0; j < this.Vectors.get(i).getDimension(); j++) {
					//TODO Change if necessary
					
					//this.Vectors(i).Vector(j) *= Other.Vectors(i).Vector(j)
					this.Vectors.get(i).setVector(this.Vectors.get(i).getVector(j) * other.getVectors(i).getVector(j), j);
				}
			}
		}
		//TODO edit this if necessary
		return this;
	}

	public ArrayList<Vector> getVectors() {
		return Vectors;
	}
	
	public Vector getVectors(int index) {
		return Vectors.get(index);
	}

	public void setVectors(ArrayList<Vector> vectors) {
		Vectors = vectors;
	}

	public int getDimension() {
		return dimension;
	}

	public void setDimension(int dimension) {
		this.dimension = dimension;
	}
}
