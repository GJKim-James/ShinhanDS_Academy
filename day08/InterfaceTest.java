package com.shinhan.day08;

import java.util.ArrayList;
import java.util.List;

import javax.management.InvalidApplicationException;

public class InterfaceTest {

	public static void main(String[] args) {
//		f1();
//		f2();
//		f3();
//		f4();
//		f5();
//		f6();
//		f7();
		f9();
	}

	private static void f9() {
		MyBox myBox = new MyBox();
		Changeable myBox2 = new MyBox();
		Resizable myBox3 = new MyBox();
		Colorable myBox4 = new MyBox();
	}

	private static void f8(Movable aa) {
		aa.moveBy(1, 2);
		aa.moveTo(3, 4);
	}
	
	private static void f7() {
		// 구현 클래스 type
		TransformImpl a1 = new TransformImpl();
		// 구현 클래스가 implement 받은 인터페이스
		Transformable a2 = new TransformImpl();
		// 구현 클래스가 implement 받은 인터페이스의 상위 인터페이스
		Movable a3 = new TransformImpl();
		// 구현 클래스의 부모 클래스
		Object a4 = new TransformImpl();
		
		System.out.println(a4.getClass().getName());
		a3.moveBy(1,  2);
		a3.moveTo(3,  4);
		a2.moveBy(1,  2);
		a2.moveTo(3,  4);
		a2.resize(5,  6);
		
		a1.moveBy(1,  2);
		a1.moveTo(3,  4);
		a1.resize(5,  6);
		a1.f1();
		System.out.println(a1.getClass().getName());
		
		// 위에 코드가 반복되므로 f8()로 함수화
		f8(a1);
		f8(a2);
		f8(a3);
//		f8(a4);
	}

	private static void f6() {
		// 인터페이스는 객체 생성 불가(Cannot instantiate the type Lendable)
//		Lendable a = new Lendable();
		// Lendable a = new Lendable();
		CDInfo a1 = new CDInfo("123", "ㅇㅇㅇ");
		AppCDInfo a2 = new AppCDInfo("123", "ㅇㅇㅇ");
		Lendable a3 = new AppCDInfo("123", "ㅇㅇㅇ");
		Object a4 = new AppCDInfo("123", "ㅇㅇㅇ");
		
		SeparateVolume b1 = new SeparateVolume("124", "자바", "신용권");
		Lendable b2 = new SeparateVolume("124", "자바", "신용권");
		Object b3 = new SeparateVolume("124", "자바", "신용권");
	}

	private static void f5() {
		AppCDInfo appCDInfo = new AppCDInfo("123", "타이틀");
//		Lendable appCDInfo = new AppCDInfo("123", "타이틀");
		
//		appCDInfo.checkOut("김광진", "2024-10-08");
//		appCDInfo.checkIn();
		action(appCDInfo, "김광진", "2024-10-08");
		
		SeparateVolume separateVolume = new SeparateVolume("1234", "자바", "신용권");
//		Lendable separateVolume = new SeparateVolume("1234", "자바", "신용권");
		
//		separateVolume.checkOut("김광진2", "2024-10-08");
//		separateVolume.checkIn();
		action(separateVolume, "김광진2", "2024-10-08");
	}
	
	private static void action(Lendable lendable, String name, String date) {
		lendable.checkOut(name, date);
		lendable.checkIn();
	}

	private static void f4() {
		// Collection ; List, Set, Map
		// List Interface를 구현한 클래스 : ArrayList, LinkedList, Vector
		// 순서 있음, 중복 허용
		List<String> list = new ArrayList<>();
		
		list.add("월");
		list.add("화");
		list.add("월");
		
		for (String str : list) {
			System.out.println(str);
		}
	}

	private static void f3() {
		RemoteControl remoteControl = new Audio();
		remoteControl.turnOn();
		remoteControl.turnOff();
		
		RemoteControl2 b = (RemoteControl2) remoteControl;
		b.turnOn2();
		b.turnOff2();
	}

	private static void f2() {
		String s1 = "자바";
		// 부모 class = 자식 객체
		Object obj1 = s1;
		// Interface = 자식 객체
		CharSequence obj2 = s1;
		
		// Object 기능
		System.out.println(obj1.getClass().getName());
		// CharSequence 기능, Interface에는 실제 기능은 없고, 구현 클래스가 구현함
		System.err.println(obj2.length());
	}

	private static void f1() {
		MyInterfaceImpl1 myInterfaceImpl1 = new MyInterfaceImpl1();
		
		MyInterfaceImpl2 myInterfaceImpl2 = new MyInterfaceImpl2();
		myInterfaceImpl2.display();
		System.out.println("----------------------------------------");
		myInterfaceImpl2.print1();
		myInterfaceImpl2.print2();
		System.out.println("----------------------------------------");
		myInterfaceImpl2.print3();
		
		work(myInterfaceImpl1);
		work(myInterfaceImpl2);
	}
	
	// 자동 형 변환 : Interface = 구현 클래스
	private static void work(MyInterface myInterface) {
		// myInterface.display(); 불가
		// 강제 형 변환 : 구현 클래스 = (구현 클래스) Interface
		if (myInterface instanceof MyInterfaceImpl2 impl2) {
			impl2.display();
			System.out.println("----------------------------------------");
		}
		
		myInterface.print1();
		myInterface.print2();
		System.out.println("----------------------------------------");
		myInterface.print3();	
	}

}
