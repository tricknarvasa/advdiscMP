//EMBESTRO, Eric
//NARVASA, Patrick
//ADVDISC S18 MP 2
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
			Vectors= list;

			this.dimension = dimension;
		}
		
	}
	
	//Matrix multiplication
	public Matrix times(Matrix other) {
		Matrix product;
		//if the other is 1x1 matrix
		if (other.getDimension() == other.getVectors(0).getDimension())
			for (int i = 0; i < this.dimension; i++)
				this.getVectors(i).scale(other.getVectors(0).getVector(0));
		
		else if (this.Vectors.size() != other.Vectors.get(0).getlength() && 
				other.Vectors.size() == this.Vectors.get(0).getlength()){
			double[][] a = new double[this.Vectors.size()][this.Vectors.get(0).getlength()];
			double[][] b = new double[other.Vectors.size()][other.Vectors.get(0).getlength()];
			double[][] prod= new double[this.Vectors.size()][other.Vectors.get(0).getlength()];
			
			for(int i=0; i<this.Vectors.size();i++){
				for(int j=0; j< this.Vectors.get(0).getlength(); j++){
					prod[i][j]+= (a[i][j] * b[j][i]);
				}
			}
			
			for(int i=0; i<dimension;i++){
				tobeadded= new Vector(inverse[i],dimension);
				iMatrix.add(tobeadded);
				}
			
			product= new Matrix(iMatrix,this.getDimension());
			
			else{
				System.out.print("size mismatch");
				return null;
			}

		
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
		Matrix inverseMatrix;
		ArrayList<Vector> iMatrix = new ArrayList<>();
		Vector tobeadded= new Vector(dimension);
		
		if(this.det()!= 0){ //checks if matrix has inverse
			
			for(int i=0; i<dimension; i++){//create identity matrix
				for(int j=0; j<dimension; j++){
					if(i==j){
						inverse[i][j]=1.0;
					}
					else
						inverse[i][j]=0.0;
					}
			}
		
			for(int i=0; i<dimension; i++){ //transform into 2D Array
				for(int j=0; j<dimension; j++){
					matrix[i][j]= Vectors.get(i).getVector(j);
					}
			
			}
			inverse= GJforInverse(matrix,inverse,dimension);
		
			for(int i=0; i<dimension;i++){
				tobeadded= new Vector(inverse[i],dimension);
				iMatrix.add(tobeadded);
				}
			
			inverseMatrix= new Matrix(iMatrix,this.getDimension());
		
			return inverseMatrix;
		}
		
		else{
			System.out.print("Undefined");
			return null;
		}
	}
	
	
	public double GJforDet(double[][]matrix, int dimension){ //This  function finds the determinant using Gauss Jordan
	
		
		int pivotrow=0;
		int pivotcol=0;
		double multiplier;
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
					if( i==pivotrow && j== pivotcol){ //This converts values under pivot point into 0
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
			if(flag){ //moves pivot point
				pivotrow+=1;
				pivotcol+=1;
				flag= false;
			}
		
		}
		//Multiply diagonal to get determinant value
		for(int i=0;i<dimension;i++){
			for(int j=0;j<dimension;j++){
				if(i==j){
					determinant*=matrix[i][j];
				}
			}
		}
		//check sign
		if(!sign){
			determinant*= -1;
		}
		
		
		return determinant;
	}
	
	//find determinant
	public double det() {
		double matrix[][]=new double[dimension][dimension];
		double determinant=1;
		boolean allow=true;
		for(int i=0;i<dimension;i++){
			if(this.Vectors.get(i).getlength()==dimension){
				allow=true;
			}
			else{
				allow=false;
				break;
			}
		}
		if(allow){
			for(int i=0; i<dimension; i++){
				for(int j=0; j<dimension; j++){
					matrix[i][j]= Vectors.get(i).getVector(j);
				}
			
			}
			
		determinant=GJforDet(matrix,dimension);
		return determinant;
		}
		else{
			return '0';
		}
	}
	
	//Tranpose
	public Matrix transpose(){
		double [][] matrix= new double[this.getDimension()][this.Vectors.get(0).getlength()];
		double [][] transposedmatrix= new double[this.Vectors.get(0).getlength()][this.getDimension()];
		ArrayList<Vector> tMatrix = new ArrayList<>();
		Vector thisvec= new Vector(this.dimension);
		
		
		
		for(int i=0; i<dimension; i++){ //transform into 2D Array
			for(int j=0; j<dimension; j++){
				matrix[i][j]= Vectors.get(i).getVector(j);
				}
		
		}
	
		for(int i=0;i<this.getDimension();i++){
			for(int j=0; j< this.Vectors.get(0).getlength(); j++){
				transposedmatrix[j][i]= matrix[i][j];
			}
						
		}
		
		printMatrix(transposedmatrix);
		
		for(int i=0; i<this.Vectors.get(0).getlength();i++){
			thisvec= new Vector(transposedmatrix[i],this.getDimension());
			tMatrix.add(thisvec);
			}
		
		Matrix transmat= new Matrix(tMatrix,this.getDimension());
		System.out.print(tMatrix.get(0).getVector(0));
		
		return transmat;
	
		
	}
	//Setters Getters
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
