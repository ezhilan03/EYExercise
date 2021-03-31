package InternExercise.day11;
import java.util.Arrays;

public class Day3Question3 {
	public static void main(String[] args) throws Exception{
		FixedStack staticStack = (FixedStack)Class.forName(args[0]).getConstructor(new Class[] {int.class}).newInstance(new Object[] {5});
		DynamicStack dynamicStack = (DynamicStack)Class.forName(args[1]).getConstructor(new Class[] {int.class}).newInstance(new Object[] {5});
		dynamicStack.push(9);
		dynamicStack.push(8);
		dynamicStack.push(7);
		dynamicStack.push(6);
		dynamicStack.push(5);
		dynamicStack.push(4);
		dynamicStack.push(3);
		dynamicStack.pop();
		System.out.println(dynamicStack);
		
		staticStack.push(1);
		staticStack.push(2);
		staticStack.push(3);
		staticStack.push(4);
		staticStack.push(5);
		System.out.println(staticStack);
	}
}

interface Stack{
	public void push(int num);
	public void pop();
}

class FixedStack implements Stack{
	private int[] arr;
	private int top=-1;
	private int size;
	
	public FixedStack(int size) {
		this.size=size;
		arr=new int[size];
	}
	
	 @Override
	public void push(int num) {
		if(top==size-1)
			System.out.println("The stack is full");
		else
			arr[++top]=num;
	}
	 @Override
	public void pop() {
		if(top==-1)
			System.out.println("stack is empty");
		else {
			System.out.println("the popped element is "+arr[top]);
			arr[top--]=0;
		}
	 }
	 @Override
	public String toString() {
		String s="";
		for(int i=0;i<=top;i++) {
			s+=arr[i];
			s+=" ";
		}
		return "the static stack is "+s;
	}
}

class DynamicStack implements Stack{
	private int[] arr;
	private int size;
	private int top=-1;
	
	public DynamicStack(int size) {
		this.size=size;
		arr=new int[size];
	}
	
	@Override
	public void push(int num) {
		if(top==size-1) {
			this.increaseSize();
		}
		arr[++top]=num;
	}
	
	@Override
	public void pop() {
		if(top==-1)
			System.out.println("Stack is empty");
		else {
			System.out.println("popped element is "+arr[top]);
			arr[top--]=0;
		}
	}
	
	private void increaseSize() {
		int newArr[] = new int[this.size * 2];
		for(int i=0;i<=top;i++) {
			newArr[i]=arr[i];
		}
		this.arr=newArr;
		this.size=size*2;
	}
	
	@Override
	public String toString() {
		String s="";
		for(int i=0;i<=top;i++) {
			s+=arr[i];
			s+=" ";
		}
		return "the dynamic stack is "+s;
	}
	
}