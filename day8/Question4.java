package EYExercise.day8;

import java.util.Arrays;

public class Question4 {
	public static void main(String[] args) {
		Stack s = new Stack(5);
		s.push(1);
		s.push(2);
		s.push(3);
		System.out.println(s);
		s.pop();
		System.out.println(s);
	}
}
class Stack{
	private int[] arr;
	private int top = -1;
	private int capacity;
	
	public Stack(int size) {
		arr=new int[size];
		capacity=size;
	}
	public void push(int i) {
		if(top==capacity-1) 
			System.out.println("the stack is full");
		else 
			arr[++top]=i;
	}
	public void pop() {
		if(top==-1) 
			System.out.println("the stack is empty");
		else {
			System.out.println("the popped element is  "+arr[top]);
			arr[top--]=0;
	}}
	@Override
	public String toString() {
		return  Arrays.toString(arr);
	}
	
}
