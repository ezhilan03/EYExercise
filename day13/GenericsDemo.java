package InternExercise.day13;

public class GenericsDemo {
	public static void main(String[] args) {
		PaintBrush<Water> brush1 = new PaintBrush<Water>();
		brush1.setObj(new Water());
		System.out.println(brush1.getObj());
		
		PaintBrush<Paint> brush2 = new PaintBrush<Paint>();
		brush2.setObj(new RedPaint());
		System.out.println(brush2.getObj());
	}
}

class PaintBrush<T>{
	T tObj;
	public T getObj() {
		return tObj;
	}
	
	public void setObj(T tObj) {
		this.tObj=tObj;
	}
}

abstract class Paint{
	
}

class RedPaint extends Paint{
	
}

class Water{
	
}