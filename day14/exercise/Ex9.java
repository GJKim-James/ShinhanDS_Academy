package com.shinhan.day14.exercise;

// 16장 확인문제 9번

// 8번 문제에서 Example 클래스의 main() 메소드를 실행할 때,
// avg() 메소드의 매개값으로 람다식을 사용하지 않고 메소드 참조로 변경
public class Ex9 {

//	double englishAvg = avg( s -> s.getEnglishScore() );
	double englishAvg = avg(Student::getEnglishScore);

//	double mathAvg = avg( s -> s.getMathScore() );
	double mathAvg = avg(Student::getMathScore);

}
