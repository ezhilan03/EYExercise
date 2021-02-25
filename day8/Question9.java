package EYExercise.day8;

public class Question9 {
	
}
class A{
	public int pub;
	protected int pro;
	int nomod;
	private int pri;
	
	public void pubMet() {}
	protected void proMet() {}
	void nomodMet() {}
	private void priMet() {}
}

class B extends A{
	void met() {
		pub=10;
		pro=9;
		nomod=8;
		pri=7;
		
		pubMet();
		proMet();
		nomodMet();
		priMet();
	}
	
}