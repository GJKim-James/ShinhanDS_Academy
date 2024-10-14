package com.shinhan.day10;

import java.util.Arrays;
import java.util.HashSet;

public class Lotto {
	
	public static void main(String[] args) {
		// 1 ~ 45
		// 0 <=   < 1
		// 0 <=   < 45
		// 1 <=   < 46
		// 중복 없이 1~45인 6개의 무작위 수를 구하기 (배열, HashSet)
		// HashSet : 순서 없음, 중복 불가
		HashSet lotto = new HashSet<Integer>();

		while(lotto.size()<6)
		{
			int n = (int) (Math.random() * 45) + 1;
			lotto.add(n);
		}
		System.out.println("HashSet : " + lotto);

		// 배열
		int[] arr = new int[6];
		int index = 0;aa:while(index<6)
		{
			int n = (int) (Math.random() * 45) + 1;

			for (int i = 0; i < index; i++) {
				if (n == arr[i]) {
					continue aa;
				}
			}
			arr[index++] = n;
		}
		System.out.println("Array : " + Arrays.toString(arr));
	}

}
