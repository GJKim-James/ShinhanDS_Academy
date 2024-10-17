package com.shinhan.day12.exercise;

// 13장 확인문제 2번

class Container<T> {
	T t;

	public T get() {
		return t;
	}

	public void set(T t) {
		this.t = t;
	}
	
	
}

public class ContainerExample {

	public static void main(String[] args) {
		Container<String> container1 = new Container<String>();
		container1.set("홍길동");
		String str = container1.get();
		System.out.println("str : " + str);

		Container<Integer> container2 = new Container<Integer>();
		container2.set(6);
		int value = container2.get();
		System.out.println("value : " + value);
	}

}
