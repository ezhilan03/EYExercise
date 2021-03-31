package model;

import java.util.ListResourceBundle;

public class Dictionary_ta extends ListResourceBundle{
	
	Object obj[][] = {
			{"username","உங்கள் பெயர்"},
			{"password","கடவுச்சொல்"}
	};
	
	@Override
	protected Object[][] getContents() {
		return obj;
	}
}
