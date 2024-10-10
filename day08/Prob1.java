package com.shinhan.day08;

/*
 * 문제. 주어진 Prob1.java 파일을 이용하여 결과대로 나올 수 있게 Entry 클래스의 하위 클래스인 Directory 클래스와 File 클래스를 완성 하시요.
 * 
 * 
 * <<수행결과>>
 * tesD
 * testF(1000)
 * 	
 * <<참고 및 주의사항>>
 * - main 메서드는 수정없이 그대로 사용합니다.
 * - 주어진 메소드의 signature는 변경하지 않습니다.
 * - Entry 클래스는 수정없이 그대로 사용합니다.
 * - File 클래스와 Directory 클래스내에 어떠한 변수도 선언되지 않아야 합니다.
 */
public class Prob1 {

	public static void main(String[] args) {
		// 자동 형 변환 : 부모 = 자식
		Entry e1 = new Directory("tetD");
		e1.print(); // tesD
		Entry e2 = new File("testF", 1000);
		e2.print(); // TestF(1000)
	}

}

// abstract class : class 안에 추상 메서드가 1개 이상 있다.
// 직접 생성 불가(new Entry() 불가)
abstract class Entry {
	// 1. field
	private String name;
	private int size;

	// 2. constructor
	public Entry() {
		super();
	}

	public Entry(String name) {
		super();
		this.name = name;
	}

	public Entry(int size) {
		super();
		this.size = size;
	}

	public Entry(String name, int size) {
		super();
		this.name = name;
		this.size = size;
	}

	// 3. 일반 메서드(Getter, Setter)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	// 추상 메서드 : 정의만 있고 구현은 없다. 구현은 필수적으로 자식이 한다.
	public abstract void print();

}

class Directory extends Entry {
	
	Directory(String name) {
		super(name);
	}

	@Override
	public void print() {
		System.out.println(getName());
	}

}

class File extends Entry {

	public File(String name, int size) {
		super(name, size);
	}

	@Override
	public void print() {
		System.out.println(getName() + "(" + getSize() + ")");
	}

}
