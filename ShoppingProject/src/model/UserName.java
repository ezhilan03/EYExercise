package model;

import javax.servlet.http.HttpSession;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

public class UserName extends TagSupport{
	private String key;
	public final String getKey() {
		return key;
	}

	public final void setKey(String key) {
		this.key = key;
	}

	@Override
	public int doEndTag() throws JspException {
		HttpSession session = pageContext.getSession();
		String userName = (String)session.getAttribute("uname");
		JspWriter out = pageContext.getOut();
		try {
			out.println(userName);
		}catch(Exception e) {e.printStackTrace();}
		return super.doEndTag();
	}
}
