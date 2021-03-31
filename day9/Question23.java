package InternExercise.day9;

public class Question23 {
	public static void main(String[] args) {
		final float pi = 3.141f;
		int r = 4;
		int h = 3;
		int acceleration = 10;
		float velocity = 0.5f;
		float mass = 1.5f;
		
		
		float area = (pi*r*r)+(2*pi*r*h);
		float energy = mass*(acceleration*h +(velocity*velocity)/2);
		System.out.println(area);
		System.out.println(energy);
	}
}
