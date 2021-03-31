package InternExercise.day8;

public class Question14 {
	public static void main(String[] args) {
		new Result().calculate();
	}
}

class Student{
	private int rollno = 88;
	private String name = "Ezhilan";
	public final int getRollno() {
		return rollno;
	}
	public final String getName() {
		return name;
	}
	
}

class Exam extends Student{
	private int mathsMark=100;
	private int scienceMark=99;
	private int englishMark=98;
	public final int getMathsMark() {
		return mathsMark;
	}
	public final int getScienceMark() {
		return scienceMark;
	}
	public final int getEnglishMark() {
		return englishMark;
	}
}

class Result extends Exam{
	private int totalMark;
	public void calculate(){
		Exam examObj = new Exam();
		System.out.println("The Total marks of "+new Student().getName()+" is "+(examObj.getEnglishMark()+examObj.getMathsMark()+examObj.getScienceMark()));
	}
}