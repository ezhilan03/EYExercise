package EYExercise.day8;

public class Question7 {
	public static void main(String[] args) {
		final ReferenceVariable var1 = new ReferenceVariable("Solid state");
		var1.changeState("Gas state");
		var1.getState();
	}
}
class ReferenceVariable{
	private String state;
	public ReferenceVariable(String state) {
		this.state=state;
	}
	public void changeState(String state) {
		this.state=state;
	}
	public void getState() {
		System.out.println("The state of the variable is "+this.state);
	}
}