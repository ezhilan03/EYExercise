package InternExercise.day9;

public class Question5 {
	public static void main(String[] args) {
		int count=0;
		for(int i=1;i<=4;i++) {
			for(int j=1;j<=4;j++) {
				for(int k=0;k<=4;k++) {
					if(k!=i && k!=j && i!=j) {
						count++;
						System.out.println(i+""+j+""+k);
					}
				}
			}
		}
		System.out.println("The number of unique numbers is "+count);
	}
}
