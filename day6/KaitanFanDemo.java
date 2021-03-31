package InternExercise.day6;
import java.util.Scanner;
public class KaitanFanDemo {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		KaitanFan fan = new KaitanFan();
		while(true) {
			System.out.println("enter anything to pull");
			sc.next();
			fan.pull();
		}
		}
	}


class KaitanFan{
	State state = new OffState();
	public void pull() {
		System.out.println(state+"this state is changed to");
		state.changeState(this);
	}
}

abstract class State{
	abstract void changeState(KaitanFan fan);
}

class SlowSpeedState extends State{
	@Override
	void changeState(KaitanFan fan) {
		System.out.println("Medium speed");
		fan.state=new MediumSpeedState();
	}
	
}

class MediumSpeedState extends State{
	@Override
	void changeState(KaitanFan fan) {
		System.out.println("Fast speed");
		fan.state=new FastSpeedState();
	}
}

class FastSpeedState extends State{
	@Override
	void changeState(KaitanFan fan) {
		System.out.println("Switch Off");
		fan.state=new OffState();
	}
}

class OffState extends State{
	@Override
	void changeState(KaitanFan fan) {
		System.out.println("Slow speed");
		fan.state=new SlowSpeedState();
	}
}