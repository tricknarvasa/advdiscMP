
public class Vector {
	
	public double vector[];
	public int dimension;
	
	//first constructor
	public Vector(int dimension) {
		this.dimension=dimension;
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
			this.dimension= dimension;
		this.vector = new double[dimension];
		
		for(int i=0; i<dimension;i++)
			vector[i]= array[i];
		}
	}
	
	public void scale(double scalar){
		
		for(int i=0; i<dimension;i++){
			this.vector[i]= (this.vector[i] * scalar);
		}
	
	}
}
