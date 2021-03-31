package model;

import java.util.ListResourceBundle;

public class Dictionary_te extends ListResourceBundle{
	
	Object obj[][] = {
			{"username","నీ పేరు"},
			{"password","పాస్వర్డ్"}
	};
	
	@Override
	protected Object[][] getContents() {
		return obj;
	}
}
