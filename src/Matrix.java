import java.util.ArrayList;
import java.util.List;

public class Matrix{

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
	public double [][] swap(double [][] matrix, int index1, int index2){

		double temp;
		for(int i=0; i<dimension; i++){
			temp= matrix[index1][i];
			matrix[index1][i]= matrix[index2][i];
			matrix[index2][i]=temp;
		}
		
		return matrix;
	}
	public double [][] addVectors(double [][] matrix, int index1, int index2, double multiplier){

		double temp;
		for(int i=0; i<dimension; i++){
			temp= matrix[index1][i]*(multiplier);
			
			matrix[index2][i]= matrix[index2][i] + temp;
			
			
		}
		
		return matrix;
	}

	public double[][] GJforInverse(double[][] matrix, double [][] inverse,int dimension){
		
	
		double x=0,temp;
		int pivotrow=0;
		int pivotcol=0;
		double multiplier;
		double dividend;
		boolean flag=false;
		boolean f=true;
	
		
		for(int i=0; i<dimension; i++){

			for(int j=0; j<dimension;j++){
			
			if(j==i){
				if(matrix[pivotrow][pivotcol]!=1 || matrix[pivotrow][pivotcol]== 0){
						if(matrix[pivotrow][pivotcol]!=1){
						for(int checkpivot=pivotrow;checkpivot<dimension;checkpivot++){
							if(matrix[checkpivot][pivotcol]==1){
								matrix=swap(matrix,pivotrow,checkpivot);
								inverse=swap(inverse,pivotrow,checkpivot);
								f=false;
								break;
							}
							else{
								f=true;
							}
						
							}
						}
						if(f==true && matrix[pivotrow][pivotcol]!= -1 ){
								dividend= matrix[i][j];
								for(int g=0;g<dimension;g++){
									matrix[i][g]= matrix[i][g]/dividend;
									inverse[i][g]=inverse[i][g]/dividend;
								}
							f=false;
						}
						
						if(f==true && matrix[pivotrow][pivotcol]== -1 ){
							
							for(int g=0;g<dimension;g++){
							
								
								matrix[i][g]= matrix[i][g]*	-1.0;
								inverse[i][g]= inverse[i][g]*-1.0;
								
							}
						}
					}
					if( i==pivotrow && j== pivotcol){
						for(int k=i+1; k<dimension;k++){
							if(matrix[k][j]!=0){
								multiplier= (matrix[k][j]/ matrix[i][j]);
								
								if(matrix[k][j]/(matrix[k][j]*-1)== -1 && matrix[k][j]/(matrix[k][j]*-1) != 0 )
									multiplier*=-1;
							
								matrix= addVectors(matrix,i,k,multiplier);
								
								inverse= addVectors(inverse,i,k,multiplier);
								
							}
							
						}
						
					}
					
						flag=true;
					}
				}
				if(flag){
				pivotrow+=1;
				pivotcol+=1;
				flag= false;
				}
			}
			
		
		inverse= RREforInverse(matrix,inverse,dimension);
		
		return inverse;
}
	public double[][] RREforInverse(double[][] matrix, double[][] inverse,int dimension){
		
		
		double x=0,temp;
		int pivotrow=dimension-1;
		int pivotcol=dimension-1;
		double multiplier;
		double dividend;
		boolean flag=false;
		
		//1. Check if Solvable
		
		//2. Gauss_Jordan
		for(int i=pivotrow; i>=0; i--){

			for(int j=pivotcol; j>=0;j--){
			
				if(j==i){
					
					if( i==pivotrow && j== pivotcol){
					
						for(int k=i-1; k>=0;k--){
							if(matrix[k][j]!=0){
								
								multiplier= (matrix[k][j]/ matrix[i][j]);
								
								if(matrix[k][j]/(matrix[k][j]*-1)== -1)
									multiplier*=-1;
								
								matrix= addVectors(matrix,i,k,multiplier);
								inverse=addVectors(inverse,i,k,multiplier);
							}
							
						}
						
					}
					
					flag=true;
				}
				
			}
			if(flag){
			pivotrow-=1;
			pivotcol-=1;
			flag= false;
			}
		}
		
	
		return inverse;
		
	}
	
	public void printMatrix(double [][] matrix){
		for(int i=0;i<dimension;i++){
			for(int j=0;j<dimension;j++){
				System.out.print(matrix[i][j] +" " +"|");
			}
			System.out.println();
		}
	}
	
	public Matrix inverse() {
		
		double matrix[][]=new double[dimension][dimension];
		double inverse[][]= new double[dimension][dimension];
		Matrix inverseMatrix= new Matrix(dimension);
		Vector tobeadded= new Vector(dimension);
		
		//create identity matrix
		for(int i=0; i<dimension; i++){
			for(int j=0; j<dimension; j++){
				if(i==j){
					inverse[i][j]=1.0;
				}
				else
					inverse[i][j]=0.0;
				}
		}
		//transform into 2D Array
		for(int i=0; i<dimension; i++){
			for(int j=0; j<dimension; j++){
				matrix[i][j]= Vectors.get(i).getVector(j);
				}
			
		}
		inverse= GJforInverse(matrix,inverse,dimension);
		
		for(int i=0; i<dimension; i++){
			tobeadded.setVectorArray(inverse[i]);
			inverseMatrix.Vectors.add(tobeadded);
		}
		
		return inverseMatrix;
		
	}
	
	public double GJforDet(double[][]matrix, int dimension){
		
		double x=0,temp;
		int pivotrow=0;
		int pivotcol=0;
		double multiplier;
		double dividend;
		boolean flag=false;
		boolean sign=true;
		double determinant=1;
	
		
		for(int i=0; i<dimension; i++){

			for(int j=0; j<dimension;j++){
			
			if(j==i){
				if(matrix[pivotrow][pivotcol]== 0){
					
					for(int checkpivot=pivotrow;checkpivot<dimension;checkpivot++){
						if(matrix[checkpivot][pivotcol]!=0){
							matrix=swap(matrix,pivotrow,checkpivot);
							sign=!sign;
							break;
						}
						
						}
					
				}
				
						
					if( i==pivotrow && j== pivotcol){
						for(int k=i+1; k<dimension;k++){
							if(matrix[k][j]!=0){
								multiplier= (matrix[k][j]/ matrix[i][j]);
								
								if(matrix[k][j]/(matrix[k][j]*-1)== -1 && matrix[k][j]/(matrix[k][j]*-1) != 0 )
									multiplier*=-1;
							
								matrix= addVectors(matrix,i,k,multiplier);
								
								
							}
							
						}
						
					}
					
						flag=true;
					
				}
				
				}
			if(flag){
				pivotrow+=1;
				pivotcol+=1;
				flag= false;
			}
		
		}
		
		for(int i=0;i<dimension;i++){
			for(int j=0;j<dimension;j++){
				if(i==j){
					determinant*=matrix[i][j];
				}
			}
		}
		if(!sign){
			determinant*= -1;
		}
		
		
		return determinant;
	}
	public double det() {
		double matrix[][]=new double[dimension][dimension];
		double REF[][]= new double[dimension][dimension];
		double determinant=1;
		boolean sign=true;
		Matrix inverseMatrix= new Matrix(dimension);
		Vector tobeadded= new Vector(dimension);
		
			for(int i=0; i<dimension; i++){
				for(int j=0; j<dimension; j++){
					matrix[i][j]= Vectors.get(i).getVector(j);
				}
			
			}
			
		determinant=GJforDet(matrix,dimension);
		
		
		
		return determinant;
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

//
////Vector tempCon= new Vector(dimension);
////double[][] matrix;
////matrix= this.Gauss_Jordan(Vectors, dimension, tempCon);
////this.printMatrix(matrix);
//
//double determinant = 0;
//
////TODO Getting determinant
////BaseCase 1
//if (this.getDimension() == this.getVectors(0).getDimension() && this.getDimension() == 1) {
//	determinant = this.getVectors(0).getVector(0);
//}
////BaseCase 2
//else if (this.getDimension() == this.getVectors(0).getDimension() && this.getDimension() == 2) {
//	double ad, bc;
//	ad = this.getVectors(0).getVector(0) * this.getVectors(1).getVector(1);
//	bc = this.getVectors(0).getVector(1) * this.getVectors(1).getVector(0);
//	
//	determinant = ad - bc;
//}
////BaseCase 3
//else if (this.getDimension() == this.getVectors(0).getDimension() && this.getDimension() == 3) {
//	double aei, bfg, cdh, afh, bdi, ceg;
//	
//	aei = this.getVectors(0).getVector(0) * this.getVectors(1).getVector(1) * this.getVectors(2).getVector(2);
//	bfg = this.getVectors(0).getVector(1) * this.getVectors(1).getVector(2) * this.getVectors(2).getVector(0);
//	cdh = this.getVectors(0).getVector(2) * this.getVectors(1).getVector(0) * this.getVectors(2).getVector(1);
//	
//	afh = this.getVectors(0).getVector(0) * this.getVectors(1).getVector(2) * this.getVectors(2).getVector(1);
//	bdi = this.getVectors(0).getVector(1) * this.getVectors(1).getVector(0) * this.getVectors(2).getVector(2);
//	ceg = this.getVectors(0).getVector(2) * this.getVectors(1).getVector(1) * this.getVectors(2).getVector(0);
//	
//	determinant = aei + bfg + cdh - afh - bdi - ceg;
//}
////BaseCase 4
//else if (this.getDimension() == this.getVectors(0).getDimension() && this.getDimension() > 3) {
//	//TODO gauss-jordan the matrix first
//	//TODO row echelon gj will be used
//	
//	//diagonal multiplication for det after row echelon
//	for (int i = 0; i < this.getDimension(); i++) {
//		if (determinant == 0.0)
//			determinant = this.getVectors(i).getVector(i);
//		else
//			determinant *= this.getVectors(i).getVector(i);
//	}
//}

