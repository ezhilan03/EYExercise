package day6;

public class PaintBrushDemo {
	public static void main(String[] args) throws Exception{
		PaintBrush brush = Container.getBrush("day6.RedPaint"); 
		brush.doPaint();
	}
}

class Container{
	public static PaintBrush getBrush(String paintName) throws Exception{
		PaintBrush brush = new PaintBrush();
		Paint paint = (Paint)Class.forName(paintName).newInstance();
		brush.paint=paint;
		return brush;
	}
}

class PaintBrush{
	Paint paint;
	public void doPaint() {
		System.out.println(paint);
	}
}

abstract class Paint{
	
}

class RedPaint extends Paint{
	
}

class BluePaint extends Paint{
	
}