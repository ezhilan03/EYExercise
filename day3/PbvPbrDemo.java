package InternExercise.day3;

public class PbvPbrDemo {
	public static void main(String[] args) {
		Jilabe jilabeObj = new Jilabe();
		jilabeObj.setSize(10);
		System.out.println("the size before is " + jilabeObj.getSize());
		Pbv pbv = new Pbv();
		pbv.met(jilabeObj.getSize());
		System.out.println("the size after PBV is " + jilabeObj.getSize());
		Pbr pbr = new Pbr();
		pbr.met(jilabeObj);
		System.out.println("the size after PBR is " + jilabeObj.getSize());
	}
}

class Pbv {
	public void met(int size) {
		size -= 5;
	}
}

class Pbr {
	public void met(Jilabe jilabeObj) {
		jilabeObj.setSize(5);
	}
}

class Jilabe {
	private int size;

	public void setSize(int size) {
		this.size = size;
	}

	public int getSize() {
		return this.size;
	}
}
