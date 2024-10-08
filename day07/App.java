package com.shinhan.day07;

public class App {

	public static void main(String[] args) {
//		Animal ani = new Animal(); // 직접 생성 불가
		Dog dog = new Dog();
		Cat cat = new Cat();
		
		work(dog);
		work(cat);
	}

	// 매개변수로 dog와 cat 2개 모두 받아야 하는데 받는 방법은 Dog와 Cat의 부모인 Animal로 받는다.
	public static void work(Animal animal) {
		animal.sound();
	}

}
