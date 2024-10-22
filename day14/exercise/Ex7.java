package com.shinhan.day14.exercise;

// 16장 확인문제 7번

@FunctionalInterface
interface Operator {
	int apply(int x, int y);
}

public class Ex7 {
	
	private static int[] scores = { 10, 50, 3 };

	public static int maxOrMin(Operator operator) {
		int result = scores[0];

		for (int score : scores) {
			result = operator.apply(result, score);
		}

		return result;
	}

	public static void main(String[] args) {
		// 최대값 얻기
		int max = maxOrMin(new Operator() {
			@Override
			public int apply(int x, int y) {
				if (x > y) {
					return x;
				}
				return y;
			}
		});
//		int max = maxOrMin(Math::max);
		System.out.println("최대값 : " + max);

		// 최소값 얻기
		int min = maxOrMin((x, y) -> {
			if (x < y) {
				return x;
			}
			return y;
		});
//		int min = maxOrMin(Math::min);
		System.out.println("최소값 : " + min);
	}

}
