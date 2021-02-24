package day5;

public class Question43 extends Lower{
static int i = 200;
public static void main(String argv[]){
 Question43 p = new Question43();
 System.out.println(i);
 }
}
private class Lower{ // class can have only default or public modifiers.
Lower(){
 int i = 100;
 System.out.println(i);
 }
}