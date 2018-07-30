
public class Driver {
	
	public static void main (String[] args) {
		
		Vector vector = new Vector(5);
//				
		double[] array = {1,2,3,4,5};
		Vector rotcev = new Vector(array, array.length);
		
		vector.add(rotcev);
		
		System.out.println("VECTOR");
		for (int i = 0; i < vector.getDimension(); i++) {
			System.out.println(vector.getVector(i));
		}
		
		System.out.println("ROTCEV");
		for (int i = 0; i < rotcev.getDimension(); i++) {
			System.out.println(rotcev.getVector(i));
		}
		
		
	}
}
