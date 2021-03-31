package InternExercise.day19;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class ForkJoinDemo {
	public static void main(String[] args) {
		String arr[]={"nikki","somu","maggi","nikki","nikki","mani","nikki","raghu","ramu","johny"};
		
		ForkJoinPool fjp=ForkJoinPool.commonPool();
		Counter task1=new Counter(arr,0,3);
		Counter task2=new Counter(arr,3,6);
		Counter task3=new Counter(arr,6,8);
		Counter task4=new Counter(arr,8,10);
		
		int result1=fjp.invoke(task1);
		int result2=fjp.invoke(task2);	
		int result3=fjp.invoke(task3);	
		int result4=fjp.invoke(task4);
		
		int count=result1+result2+result3+result4;
		
		System.out.println("Total Number of NIKKIs are...:"+count);
	}
}

class Counter extends RecursiveTask<Integer>{
	int start; int end;String[] arr;
	
	public Counter(String[] arr,int start, int end) {
		this.arr=arr;
		this.start=start;
		this.end=end;
	}
	public Integer compute() {
		int c=0;
		for(int i=start;i<end;i++) {
			if(arr[i].equalsIgnoreCase("nikki")) {
				c++;
			}
		}
	return c;
	}
}
