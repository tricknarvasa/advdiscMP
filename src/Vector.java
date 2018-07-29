
public class Vector {
	int v[][];
	 Vector (int dimension){
		 int temp[][]= new int[dimension][dimension];
		 for(int i=0; i<dimension; i++)
			 for(int j=0; j<dimension; j++)
				 temp[i][j]=0;
		this.v= temp;
	 }

}
