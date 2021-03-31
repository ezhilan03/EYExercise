package InternExercise.day1Exercise;
//25
public class ProtectedBase {

}

protected class base{ //illegal modifier for class(top level).
	String method() {
		return "Wow";
	}
}
class derived{
	public void useD() {
		base z = new base();
		System.out.println("base says"+z.method());
	}
}

