package model;

import java.util.ListResourceBundle;

public class Dictionary_hi extends ListResourceBundle{
	
	Object obj[][] = {
			{"username","आपका नाम"},
			{"password","पारण शब्द"}
	};
	
	@Override
	protected Object[][] getContents() {
		return obj;
	}
}
