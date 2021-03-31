package InternExercise.day9;

public class Question49 {
	public static void main(String args[]) {
	    Box box = new Box(10, 20, 15);	 
	    double vol = box.volume();
	    System.out.println("Volume is " + vol);
	  }
}
class Box {
	  double width;
	  double height;
	  double depth;
	
	  Box(double w, double h, double d) {
	    width = w;
	    height = h;
	    depth = d;
	  }
	
	  double volume() {
	    return width * height * depth;
	  }
	}