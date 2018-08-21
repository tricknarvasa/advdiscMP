//EMBESTRO, Eric
//NARVASA, Patrick
//ADVDISC S18 MP 2
import java.util.*;

public class Vector {
	
	private double[] vector;
	private int dimension;
	
	//First Constructor
	public Vector(int dimension) {
		this.vector = new double[dimension];
		this.dimension = dimension;
	}
	
	//Second Constructor
	public Vector(double[] array, int dimension) {
		if (array.length != dimension)
			System.out.println("array and dimension mismatch.");
		else {
			this.vector = array;
			this.dimension = dimension;
			}
		
	}
	
	//Vector Scale
	public Vector scale(double scalar){
		for (int i = 0; i < this.dimension; i++)
			this.vector[i] *= scalar;
		
		return this;
	}
	public Vector divide(double scalar){
		for (int i = 0; i < this.dimension; i++)
			this.vector[i] /= scalar;
		
		return this;
	}
	
	//Vector Add
	public Vector add(Vector addend) {
		for (int i = 0; i < this.dimension; i++)
			this.vector[i] += addend.vector[i];
		
		return this;
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
	
	
	public static boolean isSolvable (List<Vector> vectors, Vector constants) {
		if (vectors.size() == constants.getVector().length)
			return true;
		else
			return false;
	}
	
	
	public double[][] Gauss_Jordan(ArrayList<Vector> vectors, int dimension, Vector constants){
		
		double matrix[][]=new double[dimension][dimension+1];
		double x=0,temp;
		int pivotrow=0;
		int pivotcol=0;
		double multiplier;
		double dividend;
		boolean flag=false;
		boolean f=true;
		
		//1. Check if Solvable
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
		
		}

		//2. Gauss_Jordan
		for(int i=0; i<dimension; i++){

			for(int j=0; j<dimension+1;j++){
			
				if(j==i){
					if(matrix[pivotrow][pivotcol]!=1 || matrix[pivotrow][pivotcol]== 0){
						if(matrix[pivotrow][pivotcol]!=1){
						for(int checkpivot=pivotrow;checkpivot<dimension;checkpivot++){
							if(matrix[checkpivot][pivotcol]==1){
							
								matrix=swap(matrix,pivotrow,checkpivot);
								f=false;
								break;
							}
							else{
								f=true;
							}
						
							}
						}
						if(f){
							dividend= matrix[i][j];
							for(int g=0;g<dimension+1;g++){
							matrix[i][g]= matrix[i][g]/dividend;
							}
							f=false;
						}
					}
					if( i==pivotrow && j== pivotcol){
						for(int k=i+1; k<dimension;k++){
							if(matrix[k][j]!=0){
								multiplier= (matrix[k][j]/ matrix[i][j]);
								if(matrix[k][j]/(matrix[k][j]*-1)== -1 && matrix[k][j]/(matrix[k][j]*-1) != 0 )
									multiplier*=-1;
								matrix= addVectors(matrix,i,k,multiplier);
								printMatrix(matrix);
								System.out.println();
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
		System.out.println("Row Echolon Form:");
		printMatrix(matrix);
		matrix= RRE(matrix, dimension);
		return matrix;
	}
	
public double[][] RRE(double[][] matrix, int dimension){
		
		
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
								System.out.println(matrix[k][j]);
								multiplier= (matrix[k][j]/ matrix[i][j]);
								if(matrix[k][j]/(matrix[k][j]*-1)== -1)
									multiplier*=-1;
								
								matrix= addVectors(matrix,i,k,multiplier);
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
		
		return matrix;
	}
	

	//print
	public void printVector(){
		for(int i=0; i< dimension; i++){
			System.out.println(this.vector[i]);
		}
	}
	public void printMatrix(double [][] matrix){
	
		for(int i=0;i<dimension;i++){
			for(int j=0;j<dimension;j++){
				System.out.print(matrix[i][j] +" " +"|");
			}
			System.out.println();
		}
	}
	
	public int span(ArrayList<Vector> vectors, int dimension) {
		int span = vectors.size();
		
		for (int i = 0; i < span; i++) {
			boolean isNonZero = true;
			for (int j = 0; j < vectors.get(i).getDimension(); j++)
				if (vectors.get(i).getVector(j) == 0 && isNonZero == true) {
					isNonZero = false;
					span--;
				}
		}
			
		
		return span;
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
	public void setVectorArray(double [] vector) {
		this.vector = vector;
	}

	public int getDimension() {
		return dimension;
	}
	public int getlength(){
		return vector.length;
	}

	public void setDimension(int dimension) {
		this.dimension = dimension;
	}
}
