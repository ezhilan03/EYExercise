package InternExercise.day3;

public class Test {
	protected int pro;
	int nomad;
	private int pri;
	public int pub;

	private void primet() {
	}

	void nomadmet() {
	}

	protected void promet() {
	}

	public void pubmet() {
	}

	public void met() {
		primet();
		nomadmet();
		promet();
		pubmet();
		System.out.println(pro);
		System.out.println(nomad);
		System.out.println(pri);
		System.out.println(pub);
	}
}

class ChildTest extends Test {
	public void main(String[] args) {
		primet();
		nomadmet();
		promet();
		pubmet();
		System.out.println(pro);
		System.out.println(nomad);
		System.out.println(pri);
		System.out.println(pub);
	}
}

class NonChildTest {
	Test test = new Test();

	public void main(String[] args) {
		test.primet();
		test.nomadmet();
		test.promet();
		test.pubmet();
		System.out.println(test.pro);
		System.out.println(test.nomad);
		System.out.println(test.pri);
		System.out.println(test.pub);
	}
}