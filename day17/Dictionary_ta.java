package InternExercise.day17;

import java.util.ListResourceBundle;

public class Dictionary_ta extends ListResourceBundle{
	Object obj[][] = {
			{"hello","vanakkam"},
			{"good morning","kaalai vanakkam"}
	};
	@Override
	protected Object[][] getContents() {
		// TODO Auto-generated method stub
		return obj;
	}
}
