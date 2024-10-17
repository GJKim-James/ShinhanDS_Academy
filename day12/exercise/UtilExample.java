package com.shinhan.day12.exercise;

// 13장 확인문제 4번

class Pair<K, V> {
	private K key;
	private V value;

	public Pair(K key, V value) {
		this.key = key;
		this.value = value;
	}

	public K getKey() {
		return key;
	}

	public V getValue() {
		return value;
	}
}

class ChildPair<K, V> extends Pair<K, V> {
	public ChildPair(K k, V v) {
		super(k, v);
	}
}

class OtherPair<K, V> {
	private K key;
	private V value;

	public OtherPair(K key, V value) {
		this.key = key;
		this.value = value;
	}

	public K getKey() {
		return key;
	}

	public V getValue() {
		return value;
	}
}

class Util {
	// 방법 1
	public static <K, V> V getValue(Pair<K, V> p, K k) {
		if (p.getKey() == k) {
			return p.getValue();
		} else {
			return null;
		}
	}

	// 방법 2
//	public static <P extends Pair<K, V>, K, V> V getValue(P p, K k) {
//		if (p.getKey() == k) {
//			return p.getValue();
//		} else {
//			return null;
//		}
//	}
}

public class UtilExample {

	public static void main(String[] args) {
		Pair<String, Integer> pair = new Pair<>("홍길동", 35);
		Integer age = Util.getValue(pair, "홍길동");
		System.out.println(age);

		ChildPair<String, Integer> childPair = new ChildPair<>("홍삼원", 20);
		Integer childAge = Util.getValue(childPair, "홍삼순"); // 홍삼원, 홍삼순 불일치 -> null 출력
		System.out.println(childAge);

//		OtherPair<String, Integer> otherPair = new OtherPair<>("홍삼원", 20);
//		// OtherPair는 Pair를 상속하지 않으므로 컴파일 에러 발생
//		int otherAge = Util.getValue(otherPair, "홍삼원");
//		System.out.println(otherAge);
	}

}
