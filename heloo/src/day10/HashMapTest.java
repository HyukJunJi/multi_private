package day10;
import java.util.*;
/*Map계열
 * Hashtable, HashMap Properties
 * - Object유형을 저장할 수 있다
 * - key와 value값을 매핑하여 저장한다.
 * - key값의 중복을 허용하지 않는다.
 * - 무순서
 * - 데이터가 75%차면 자동으로 저장 역역을 확대한다.
 * - 데이터 저장: Object put(Object key, Object value)
 * - 데이터 꺼내기: Object get(Object key)
 * */
public class HashMapTest {
	public static void main(String[] args) {
		HashMap map =new HashMap();
		map.put("하나", 1);
		map.put("둘", "Two");
		map.put("파랑", "blue");
		map.put("빨강", java.awt.Color.red);
		
		String val = (String)map.get("둘");
		System.out.println(val.toLowerCase());
		
		String val2 = (String)map.get("파랑");
		System.out.println(val2.toLowerCase());
		//Generic 사용 <K,V>사용 
		HashMap<String, Integer> h = new HashMap<>();
		h.put("생년", 2000);
		h.put("나이",23);
		h.put("용돈", 500000);
		System.out.println(h);
		
		h.put("나이",33);
		
		System.out.println(h);
		
//		검색할때 유용하다.
		Integer money = h.get("용돈");
		System.out.println(money+"원");
		
		//Set<K> KeySet():key값들만 추출한다.
		
		Set<String> set = h.keySet();
		Iterator<String> it =set.iterator();
		while(it.hasNext()) {
			String s=it.next();
			Integer v=h.get(s);
			System.out.println(s+":"+v);
		}
		
		Collection<Integer> collection=h.values();
		System.out.println(collection);
		//collection<V> values():value값들만 추출한다.,
	}
}
