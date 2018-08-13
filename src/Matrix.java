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
	
	public double det() {
		double determinant = 0;
		
		//TODO Gauss Jordan
		
		
		//TODO Getting determinant
		//BaseCase 1
		if (this.getDimension() == this.getVectors(0).getDimension() && this.getDimension() == 1) {
			determinant = this.getVectors(0).getVector(0);
		}
		//BaseCase 2
		else if (this.getDimension() == this.getVectors(0).getDimension() && this.getDimension() == 2) {
			double ad, bc;
			ad = this.getVectors(0).getVector(0) * this.getVectors(1).getVector(1);
			bc = this.getVectors(0).getVector(1) * this.getVectors(1).getVector(0);
			
			determinant = ad - bc;
		}
		//BaseCase 3
		else if (this.getDimension() == this.getVectors(0).getDimension() && this.getDimension() == 3) {
			double aei, bfg, cdh, afh, bdi, ceg;
			aei = this.getVectors(0).getVector(0) * this.getVectors(1).getVector(1) * this.getVectors(2).getVector(2);
			bfg = this.getVectors(0).getVector(1) * this.getVectors(1).getVector(2) * this.getVectors(2).getVector(0);
			cdh = this.getVectors(0).getVector(2) * this.getVectors(1).getVector(0) * this.getVectors(2).getVector(1);
			
			afh = this.getVectors(0).getVector(0) * this.getVectors(1).getVector(2) * this.getVectors(2).getVector(1);
			bdi = this.getVectors(0).getVector(1) * this.getVectors(1).getVector(0) * this.getVectors(2).getVector(2);
			ceg = this.getVectors(0).getVector(2) * this.getVectors(1).getVector(1) * this.getVectors(2).getVector(0);
			
			determinant = aei + bfg + cdh - afh - bdi - ceg;
		}
		
		//TODO formula for getting determinant
		
		//formula for the first 3 cases
		if (this.getDimension() == this.getVectors(0).getDimension() && this.getDimension() == 1 || this.getDimension() == 2 || this.getDimension() == 3) {
			double[] adder, subtractor;
			adder = new double[this.getDimension()];
			subtractor = new double [this.getDimension()];
			
			//for adder
			for (int i = 0; i < this.getDimension(); i++)
				for (int j = 0; j < this.getDimension(); j++) {
					if (j == 0)
						adder[i] = this.getVectors(j).getVector(i);
					else
						adder[i] *= this.getVectors(j).getVector((i+j)%(this.getDimension()-1));
 				}
			
			//for subtractor
			for (int i = 0; i < this.getDimension(); i++)
				for (int j = 0; j < this.getDimension(); j++) {
					if (j == 0)
						subtractor[i] = this.getVectors(j).getVector(i);
					else
						subtractor[i] = this.getVectors(j).getVector(Math.abs(i-j)%(this.getDimension()-1));
				}
			
			//adding & subtracting all
			for (int i = 0; i < this.getDimension(); i++) {
				determinant += adder[i];
				determinant -= subtractor[i];
			}
		}
		return determinant;
	}
	
	public Matrix inverse() {
		//TODO this function
		
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
