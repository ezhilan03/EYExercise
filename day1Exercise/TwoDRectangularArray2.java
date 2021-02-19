package EYExercise.day1Exercise;

public class TwoDRectangularArray2 {
	public static void main(String[] args) {
		int[][] arr= {{1},{2,3},{4,5,6},{7,8,9,10}};
		for(int i=0;i<4;i++) {
			for(int j=0;j<i+1;j++) {
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}
	}
}
