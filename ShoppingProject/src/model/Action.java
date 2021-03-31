package model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

abstract public class Action {
	public abstract String execute(HttpServletRequest request, HttpServletResponse response);
}
