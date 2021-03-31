package InternExercise.day1Exercise;

public class LargestElement {
	public static void main(String[] args) {
		int[][] matrix= {{1,2,3},{4,5,6},{7,8,9}};
		for(int i=0;i<3;i++) {
			int large=0;
			for(int j=0;j<3;j++) {
				if(matrix[i][j]>large) 
					large=matrix[i][j];
			}
			System.out.println("The largest element in row "+(i+1)+" is "+large);
		}
	}
}
