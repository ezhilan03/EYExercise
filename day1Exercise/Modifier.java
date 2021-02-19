package EYExercise.day1Exercise;
//22
public class Modifier {
	public static void main(String[] args) {
		MainModifier obj = new MainModifier();
		obj.pri = 11;
		obj.nomod = 12;
		obj.pro = 13;
		obj.pub = 14;
		
		obj.primet();
		obj.nomodmet();
		obj.promet();
		obj.pubmet();
	}
}
class MainModifier{
	private int pri;
	int nomod;
	protected int pro;
	public int pub;
	
	private void primet() {	}
	void nomodmet() {}
	protected void promet() {}
	public void pubmet() {}	
}