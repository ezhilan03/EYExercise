package InternExercise.day13;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class CollectionsDemo4 {
	public static void main(String[] args) {
		Map<MyKey,String> map = new HashMap<MyKey,String>();
		MyKey key1 = new MyKey("key1");
		MyKey key2 = new MyKey("key2");
		MyKey key3 = new MyKey("key3");
		
		map.put(key1, "gold");
		map.put(key2, "silver");
		map.put(key3, "bronze");
		System.out.println(map);
		
		Map<MyKey,String> map2 = new TreeMap<MyKey,String>((o1,o2)->o2.compareTo(o1));
		map2.put(key1, "Plat");
		map2.put(key2, "Diamond");
		System.out.println(map2);
		
		Set<Map.Entry<MyKey, String>> set = map.entrySet();
		Iterator<Map.Entry<MyKey, String>> iter = set.iterator();
		while(iter.hasNext()) {
			Map.Entry<MyKey, String> entry = iter.next();
			System.out.println(entry.getKey()+" = "+entry.getValue());
		}
	}
}

class MyKey implements Comparable<MyKey>{
	String key;
	public MyKey(String key) {
		this.key=key;
	}
	@Override
	public String toString() {
		return this.key;
	}
	@Override
	public int compareTo(MyKey o) {
		return this.key.compareTo(o.key);
	}
}