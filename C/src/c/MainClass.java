package c;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

public class MainClass {
	
	public static void ex01() {
		
		List<String> list = new ArrayList<String>();
		
		list.add("봄");
		list.add("여름");
		list.add("가을");
		list.add("겨울");
		
		System.out.println(list.get(0));
		System.out.println(list.get(1));
		System.out.println(list.get(2));
		System.out.println(list.get(3));
		
		for(int i = 0; i < list.size(); i++  ) {
			System.out.println(list.get(i));
		}
		
			
	}

	public static void ex02() {
		
		TreeMap<Integer, String> treeMap = new TreeMap<Integer, String>();
		treeMap.put(90, "제시카");
		treeMap.put(100, "블랑카");
		treeMap.put(50, "제레미");
		treeMap.put(80, "사만다");
		
		System.out.println(treeMap);
		
		
		Map<Integer, String> map = new HashMap<Integer, String>();
		map.put(1, "a");
		map.put(10, "b");
		map.put(101, "c");
		map.put(11, "d");
		
		System.out.println(map);
		
		int[] arr;
		arr = new int[4];
		arr[0] = 10;
		arr[1] = 20;
		arr[2] = 30;
		arr[3] = 40;
		
		for(int n : arr) {
			n += 10;
		}
		

		
		for(int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
 		
		for(int n : arr) {
			
			n += 10;
			
		}
		
		
		
		
		
	}
	
	public static void ex03() {
		
		String name = "제시카";
		String phone = "010-1111-2222";
		int age = 20;
		
		
		Map<String, String> map = new HashMap<String, String>();
		map.put("name", name);
		map.put("phone", phone);
		map.put("age", age + ""); 	// "" 하면 int->String 가능
		
		System.out.println(map);
		
		
	}
	
	public static void ex04() {
		
		Map<String, Object> map = new HashMap<String, Object>();  // Map은 하나의 데이터
		
		map.put("Service-Key", "kdjfhkaf");
		map.put("Content-Type", "application/xml");
		
		System.out.println(map.get("Service-Key"));
		System.out.println(map.get("Content-Type"));
		
		ex05(map);
	}
	
	public static void ex05(Map<String, Object> map) {
		
		Set<Entry<String, Object>> set = map.entrySet();  // Set에 들어간 Entry (Map을 Set으로 쪼개준다)
		for(Entry<String, Object> entry : set) { 		  // keyset -> k값으로만 쪼개버려
		
	}
		for(Entry<String, Object> entry : map.entrySet() ) {
			System.out.println(entry.getKey() + " : " + entry.getValue());
		}
	}
	
	public static void main(String[] args) {
		ex02();
		
		

	}

}
