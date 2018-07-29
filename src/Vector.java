
public class Vector {
	
	public int vector[];
	
	//first constructor
	public Vector(int dimension) {
		this.vector = new int[dimension];
		for(int i=0; i<dimension;i++)
			vector[i]=0;
	}
	
	//second constructor
	public Vector(double[] array, int dimension) {
		
	}
}
