//EMBESTRO, Eric
//NARVASA, Patrick
//ADVDISC S18 MP 1
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
	
	//Vector Add
	public Vector add(Vector addend) {
		for (int i = 0; i < this.dimension; i++)
			this.vector[i] += addend.vector[i];
		
		return this;
	}
	
	public static boolean isSolvable (List<Vector> vectors, Vector constants) {
		if (vectors.size() == constants.getVector().length)
			return true;
		else
			return false;
	}
	
	
	public Vector Gauss_Jordan(ArrayList<Vector> vectors, int dimension, Vector constants){
		
		Vector finalanswer= new Vector(dimension);
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
				matrix[j][i]= vectors.get(i).getVector(j);
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
				for(int i=0; i<dimension; i++){
					finalanswer.vector[i]= (matrix[i][dimension] /matrix[i][i]);
				}
				return finalanswer;
		}
		else return null;
	}
	
	//print
	public void printVector(){
		for(int i=0; i< dimension; i++){
			System.out.println(this.vector[i]);
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

	public int getDimension() {
		return dimension;
	}

	public void setDimension(int dimension) {
		this.dimension = dimension;
	}
}
