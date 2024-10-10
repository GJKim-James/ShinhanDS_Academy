package com.shinhan.day08.lab;

/*
 * 각 클래스에 상속되어진 메소드를 파일에 주어진 명제대로 재정의 하십시오.
 * 또한 VolTest 클래스에서는 Volume 의 배열을 생성하고 각 배열의 원소에는 TV 와 Speaker 와 Radio 클래스를 넣습니다.
 * Volume 타입의 배열을 통해 서로 다른 객체의 동일한 메소드를 호출하게 됩니다.
 * 
 * 참고) 객체 지향의 설게 원칙 중에서 “개방-폐쇄의 원칙(The Open-Closed Principle)” 이 있습니다.
 * 인터페이스의 구현에는 개방되지만 인터페이스의 변경에는 폐쇄적이라는 원칙입니다.
 * 이 원칙을 이용하여 인터페이스를 사용하는 외부에서는 일관된 참조를 할 수 있으며 인테페이스를 구현하는 내부에서는
 * 다양한 구현부를 제공할 수 있다는 장점이 있습니다.
 * 
 * [실행결과]
 * speak볼륨 올립니다.100
 * speak볼륨 올립니다.100
 * speak볼륨 올립니다.100
 * speak볼륨 내립니다.0
 * speak볼륨 내립니다.0
 * speak볼륨 내립니다.0
 * Radio볼륨 올립니다.200
 * Radio볼륨 올립니다.400
 * Radio볼륨 올립니다.600
 * Radio볼륨 내립니다.300
 * Radio볼륨 내립니다.0
 * Radio볼륨 내립니다.-300
 * TV볼륨 올립니다.200
 * TV볼륨 올립니다.400
 * TV볼륨 올립니다.600
 * TV볼륨 내립니다.300
 * TV볼륨 내립니다.0
 * TV볼륨 내립니다.0
 */
public class VolumeTest {

	public static void main(String[] args) {
		
		Volume[] v = new Volume[3];
		
		v[0] = new Speaker();
		v[1] = new Radio();
		v[2] = new TV();
		
		for (int i = 0; i < v.length; i++) {
			for (int j = 1; j <= 3; j++) {
				v[i].volumeUp(200);
			}
			for (int j = 1; j <= 3; j++) {
				v[i].volumeDown(300);
			}
		}

	}

}
