package day5;
import java.applet.*;
import java.awt.*;
<applet name=MgAp code=MgAp.class height=400 width=400 parameter HowOld=30 > 
</applet>  
public class Question18 extends Applet{
    public void init(){    
    	System.out.println(getParameter("age"));  
    	} 
    }
