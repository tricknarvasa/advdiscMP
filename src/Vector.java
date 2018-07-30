
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
	
	public Vector scale(double scalar){
		
		for(int i=0; i<dimension;i++){
			this.vector[i]= (this.vector[i] * scalar);
		}
		return this;
	}
	
	public Vector add(Vector addend) {
		
		for (int i = 0; i < addend.dimension; i++) {
			this.vector[i] += addend.vector[i];
		}
		
		return this;
	}
}
