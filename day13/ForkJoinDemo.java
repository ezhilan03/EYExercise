package EYExercise.day13;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class ForkJoinDemo {
	public static void main(String[] args) {
		int[] arr = MyIntArray.arr;
		int count=0;
		for(int i:arr) {
			if(i==1) {
				count++;
			}
		}
		System.out.println("The Old fashioned count of 1 in array is "+count);
		
		ForkJoinPool fjPool = ForkJoinPool.commonPool();
		MyTasks task1 = new MyTasks(0,3,arr,1);
		MyTasks task2 = new MyTasks(3,6,arr,1);
		MyTasks task3 = new MyTasks(6,9,arr,1);
		MyTasks task4 = new MyTasks(9,12,arr,1);
		MyTasks task5 = new MyTasks(12,16,arr,1);
		
		int result1 = fjPool.invoke(task1);
		int result2 = fjPool.invoke(task2);
		int result3 = fjPool.invoke(task3);
		int result4 = fjPool.invoke(task4);
		int result5 = fjPool.invoke(task5);
		
		System.out.println("The New count of 1 is "+(result1+result2+result3+result4+result5));
	}
}

class MyTasks extends RecursiveTask<Integer>{
	int startPos,endPos,searchElem;
	int[] arr;
	public MyTasks(int startPos,int endPos,int[] arr,int searchElem) {
		this.startPos=startPos;
		this.endPos=endPos;
		this.arr=arr;
		this.searchElem=searchElem;
	}
	@Override
	protected Integer compute() {
		int count=0;
		for(int i=startPos;i<endPos;i++) {
			if(arr[i]==searchElem) {
				count++;
			}
		}
		return count;
	}
}

class MyIntArray{
	static int[] arr= {1,2,3,1,2,3,1,5,6,1,8,1,64,123,123,1};
}