
public class Vector {
	
	public double vector[];
	
	//first constructor
	public Vector(int dimension) {
		this.vector = new double[dimension];
		for(int i=0; i<dimension;i++)
			vector[i]=0;
	}
	
	//second constructor
	public Vector(double[] array, int dimension) {
		if(array.length != dimension){
			System.out.print("size incompatible");
		}
		else if(array.length == dimension ){
		this.vector = new double[dimension];
		
		for(int i=0; i<dimension;i++)
			vector[i]= array[i];
		}
	}
}
