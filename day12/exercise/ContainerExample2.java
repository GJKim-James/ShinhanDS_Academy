package com.shinhan.day12.exercise;

// 13장 확인문제 3번

class Container2<K, V> {
	K key;
	V value;

	public void set(K key, V value) {
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

public class ContainerExample2 {

	public static void main(String[] args) {
		Container2<String, String> container1 = new Container2<>();

		container1.set("홍길동", "도적");
		String name1 = container1.getKey();
		String job = container1.getValue();
		System.out.println(name1 + ", " + job);

		Container2<String, Integer> container2 = new Container2<>();

		container2.set("홍길동", 35);
		String name2 = container2.getKey();
		int age = container2.getValue();
		System.out.println(name2 + ", " + age);
	}

}
