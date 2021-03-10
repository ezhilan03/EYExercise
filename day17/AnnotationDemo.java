package EYExercise.day17;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Field;

public class AnnotationDemo {
	public static void main(String[] args) throws Exception{
		System.out.println(PaintContainer.getBrush().paint);
	}
}

@Retention(RetentionPolicy.RUNTIME)
@interface In{
	String paintClass() default "EYExercise.day17.Paint";
}


class PaintContainer{
	public static PaintBrush getBrush() throws Exception{
		PaintBrush brush = new PaintBrush();
		Field f = brush.getClass().getDeclaredField("paint");
		f.setAccessible(true);
		In in = f.getAnnotation(In.class);
		if(in!=null) {
			String paintClass=in.paintClass();
			brush.doPaint( (Paint)Class.forName(paintClass).getConstructor().newInstance() );
		}
		//brush.doPaint(new RedPaint());
		return brush;
	}
}

class PaintBrush{
	@In(paintClass="EYExercise.day17.RedPaint")
	Paint paint;
	public void doPaint(Paint paint) {
		this.paint=paint; //this is dependency injection.
	}
}

abstract class Paint{
	abstract public void Paint();
}

class RedPaint extends Paint{
	public RedPaint() {
		// TODO Auto-generated constructor stub
	}
@Override
	public void Paint() {
	}
}

class BluePaint extends Paint{
	public BluePaint() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public void Paint() {
	}
}