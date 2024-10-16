package com.shinhan.day11;

/*
 * 문제. 아래 클래스 설명을 만족하고, 배포되는 CellPhoneMain의 실행 결과가 나오도록 CellPhone 클래스를 작성하세요
 * 
 * <<CellPhoneMain 실행결과>>
 * 충전 시간 : 20분
 * 남은 배터리 양 : 60.0
 * 통화 시간 : 300분
 * 남은 배터리 양 : 0.0
 * 충전 시간 : 50분
 * 남은 배터리 양 : 100.0
 * 통화 시간 : 40분
 * 남은 배터리 양 : 80.0
 * 통화시간입력오류
 * 동일 모델입니다.
 */

//@RequiredArgsConstructor // 필수 칼럼(final)을 매개변수로 갖는 생성자 만들기
public class CellPhone {
	final String model; // 핸드폰 모델 번호
	double battery; // 남은 배터리 양
	
	// 모델 번호를 인자로 받는 생성자
	public CellPhone(String model) {
		this.model = model;
	}
	
	// 통화 시간(분)을 출력하고, 통화 시간에 따라 배터리 양을 감소시킨다.
	// 감소되는 배터리 양 = 통화시간(분) * 0.5
	// 배터리 양은 0보다 작아지지 않는다.
	// 통화 시간(분)이 0보다 작은 경우에는 IllegalArgumentException(“통화시간입력오류”)을 발생시킨다.
	public void call(int time) {
		// 강제 Exception 발생
		// Exception > RuntimeException > IllegalArgumentException
		// RuntimeException : UnChecked Exception; 처리하지 않으면 자동으로 throws 문장 추가
		// Exception : Checked Exception
		if (time < 0) {
			throw new IllegalArgumentException("통화시간입력오류");
		}
		
		System.out.println("통화 시간 : " + time + "분");
		
		battery -= time * 0.5;
		
		if (battery < 0) {
			battery = 0;
		}
	}

	// 충전한 시간(분)을 출력하고, 충전한 시간에 따라 배터리 양을 증가시킨다.
	// 충전되는 배터리 양 = 충전시간(분) * 3
	// 배터리 양은 100까지만 증가한다.
	// 충전 시간(분)이 0보다 작은 경우에는 IllegalArgumentException(“충전시간입력오류”)을 발생시킨다.
	public void charge(int time) {
		if (time < 0) {
			throw new IllegalArgumentException("충전시간입력오류");
		}
		
		System.out.println("충전 시간 : " + time + "분");
		
		battery += time * 3;
		
		if (battery > 100) {
			battery = 100;
		}
	}

	// 남은 배터리 양을 출력한다.
	public void printBattery() {
		System.out.println("남은 배터리 양 : " + battery);
	}

	// equals 재정의 안하면 Object 클래스의 equals() 그대로 사용; 주소 비교
	// 재정의할 때 주의사항 : 함수 이름, 매개변수, return 값은 같아야 하고, 접근 지정자는 같거나 넓어져야한다.
	// Object 타입의 객체를 입력받고, 입력받은 객체가 CellPhone 타입의 클래스이면서 모델 번호가 같은 경우에 true 리턴
//	@Override
//	public boolean equals(Object otherObject) {
//		CellPhone phone = (CellPhone) otherObject;
//		
//		return model.equals(phone.model);
//	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((model == null) ? 0 : model.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CellPhone other = (CellPhone) obj;
		if (model == null) {
			if (other.model != null)
				return false;
		} else if (!model.equals(other.model))
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("CellPhone [model=").append(model).append(", battery=").append(battery).append("]");
		return builder.toString();
	}

}
