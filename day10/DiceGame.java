package com.shinhan.day10;

import java.util.Arrays;
import java.util.HashSet;

/*
 * 문제. DiceGame.java 파일의 countSameEye 메쏘드를 완성하십시오.
 * 
 * int countSameEye(int n)
 * - 면이 8개인 주사위 2개를 생성한다.
 * - 주사위 2개를 동시에 n번 던졌을 때, 같은 눈이 나오는 횟수를 계산한다.
 * - 주사위를 던지는 횟수(n)의 값에 음수가 들어오면 IllegalArgumentException 을 발생시킴
 * 
 * 주의 사항 :
 * １) IllegalArgumentException 클래스는 java.lang 패키지에 존재하므로 별도로 생성하지 않습니다.
 * ２) 테스트 목적으로 스스로 main을 구현할 수 있습니다. main의 내용은 채점하지 않습니다.
 * ３) 주어진 메쏘드의 signature는 변경하지 않습니다.
 */

// 주사위
class Dice {
	int size;
	
	Dice(int size) {
		this.size = size;
	}
	
	int play() {
		// Math.random() : 0 <=   < 1
		// Math.random() * 8 : 0 <=   < 8
		// (int) (Math.random() * size) + 1 : 1 <=   < 9
		int number = (int) (Math.random() * size) + 1;
		return number;
	}
}

public class DiceGame {

	public static void main(String[] args) {
		
		DiceGame game = new DiceGame();

		int result1 = game.countSameEye(10);
		System.out.println("면의 개수가 8개인 주사위 2개를  던져서 같은 눈이 나온 횟수 : " + result1);

		int result2 = game.countSameEye(-10);
		System.out.println("면의 개수가 8개인 주사위 2개를  던져서 같은 눈이 나온 횟수 : " + result2);

	}

	private int countSameEye(int n) {
		try {
			if (n < 0) {
				throw new IllegalArgumentException("던진 횟수는 음수 불가");
				// IllegalArgumentException : unchecked Exception
			}
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			return 0;
		}
		
		Dice d1 = new Dice(8);
		Dice d2 = new Dice(8);
		
		int count = 0;
		
		for (int i = 1; i <= n; i++) {
			int n1 = d1.play();
			int n2 = d2.play();
			System.out.println(n1 + "---" + n2);
			if (n1 == n2) {
				count++;
			}
		}
		return count;
	}

}
