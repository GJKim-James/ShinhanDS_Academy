package com.shinhan.day15.exam;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Prob5 {

	public static void main(String[] args) {
		int[] answer = { 1, 4, 4, 3, 1, 4, 4, 2, 1, 3, 2 };
		int[] counter = new int[4];
		
		// 1의 갯수는 count[0]
		// 2의 갯수는 count[1]
		// 3의 갯수는 count[2]
		// 4의 갯수는 count[3]
		// counter[answer[i] - 1]++

		// 구현하시오 - 숫자들의 개수를 세어 저장하는 코드를 작성한다.
		for (int i = 0; i < answer.length; i++) {
			counter[answer[i] - 1]++;
		}

		// 구현하시오 - 출력결과와 같이 나오도록 작성한다.
		for (int i = 0; i < counter.length; i++) {
			System.out.println((i + 1) + "의 갯수는 " + counter[i] + "개 입니다.");
		}
		

		// 내 풀이
		List<Integer> list = Arrays.stream(answer).boxed().toList();

		int countOne = Collections.frequency(list, 1);
		int countTwo = Collections.frequency(list, 2);
		int countThree = Collections.frequency(list, 3);
		int countFour = Collections.frequency(list, 4);
		
		System.out.println("1의 갯수는 " + countOne + "개 입니다.");
		System.out.println("2의 갯수는 " + countTwo + "개 입니다.");
		System.out.println("3의 갯수는 " + countThree + "개 입니다.");
		System.out.println("4의 갯수는 " + countFour + "개 입니다.");
	}

}
