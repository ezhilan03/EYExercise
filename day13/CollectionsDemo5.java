package InternExercise.day13;

import java.util.Map;
import java.util.WeakHashMap;

public class CollectionsDemo5 {
	public static void main(String[] args) {
		Map<MyKey,Integer> map = new WeakHashMap<MyKey,Integer>();
		MyKey key1 = new MyKey("key1");
		MyKey key2 = new MyKey("key2");
		MyKey key3 = new MyKey("key3");
		
		map.put(key1, 10);
		map.put(key2, 20);
		map.put(key3, 30);
		
		key1=null;
		System.out.println("Before gc "+map);
		System.gc();
		System.out.println("After gc "+map);
	}
}
