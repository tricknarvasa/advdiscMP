import java.util.ArrayList;
import java.util.List;

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
	
	//Gauss Jordan Matrix
	public static boolean isSolvable (List<Vector> vectors, Vector constants) {
		if (vectors.size() == constants.getVector().length)
			return true;
		else
			return false;
	}
	
	
	public double[][] Gauss_Jordan(ArrayList<Vector> vectors, int dimension, Vector constants){
		
		
		double matrix[][]=new double[dimension][dimension+1];
		double x=0,temp;
		int pointer, k=0;
		if(isSolvable(vectors, constants)){
		//transform into matrix
		for(int i=0; i<=dimension; i++){
			if(i== dimension){
				for(int j=0; j<dimension; j++)
				matrix[j][i]=constants.getVector(j);
			}
			else if(i<dimension){
			for(int j=0; j<dimension; j++){
				matrix[i][j]= vectors.get(i).getVector(j);
				}
			}
		}
		
		//Gauss Jordan Operation
		for(int i=0;i<dimension; i++){
			
			if(matrix[i][i]==0){
				pointer=1;
				while(matrix[i+pointer][i]==0 && (i+pointer)<dimension)
					pointer+=1;
				if(i+pointer == dimension)
					break;
				
				for(int j= i; k<=dimension; k++){
					temp= matrix[j][k];
					matrix[j][k] = matrix[j+pointer][k];
					matrix[j+pointer][k]= temp;
					
							}
					}
				//Reduced Matrix
				//row echolon form
				for(int j=0;j<dimension; j++){
				
					if(j!= i){
						x= matrix[j][i] / matrix[i][i];
					
					}
					for(int y=0; y<=dimension;y++){
						matrix[j][y]-= (matrix[i][y]* x);
					}
				}
			}
				
		//transfer final solution
				return matrix;
		}
		else return null;
	}
	public double det() {
//		Vector tempCon= new Vector(dimension);
//		double[][] matrix;
//		matrix= this.Gauss_Jordan(Vectors, dimension, tempCon);
//		this.printMatrix(matrix);
		
		double determinant = 0;
		
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
		//BaseCase 4
		else if (this.getDimension() == this.getVectors(0).getDimension() && this.getDimension() > 3) {
			//TODO gauss-jordan the matrix first
			//TODO row echelon gj will be used
			
			//diagonal multiplication for det after row echelon
			for (int i = 0; i < this.getDimension(); i++) {
				if (determinant == 0.0)
					determinant = this.getVectors(i).getVector(i);
				else
					determinant *= this.getVectors(i).getVector(i);
			}
		}
		
		return determinant;
	}
	public void printMatrix(double [][] matrix){
		System.out.println("Reduced Echolon Form:");
		for(int i=0;i<dimension;i++){
			for(int j=0;j<dimension;j++){
				System.out.print(matrix[i][j] +" " +"|");
			}
			System.out.println();
		}
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
