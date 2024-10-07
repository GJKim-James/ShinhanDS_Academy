package com.shinhan.day06;

import java.util.Arrays;

/*
 * 연간 납부금액은 이번 달을 포함한 12개월 간의 납부 금액의 총합을 의미.
 * 고객들의 납부 내역과 납부 예정 금액을 분석하여 이번 달에는 VIP가 아니지만 다음 달에 VIP가 되는 고객,
 * 이번 달에는 VIP지만 다음 달에는 VIP가 아니게 되는 고객들에게 알림.
 * 
 * 고객들의 가입 기간을 담은 1차원 정수 배열 periods, 고객들의 납부 내역을 담은 2차원 정수 배열 payments와
 * 고객들의 납부 예정 금액을 담은 1차원 정수 배열 estimates.
 * 이 때, 이번 달에는 VIP가 아니지만 다음 달에 VIP가 되는 고객의 수와 이번 달에는 VIP지만 다음 달에는 VIP가
 * 아니게 되는 고객의 수를 정수 배열에 담아 return 하도록 solution 함수 작성.
 * 
 * periods[i]는 (i + 1)번 고객의 가입 기간이 몇 개월인지를 의미.
 * periods의 길이 = payments의 행의 길이 = estimates의 길이.
 * payments의 열의 길이 = 12
 * 	11보다 작은 j에 대하여 payments[i][j]는 (i + 1)번 고객이 (11 - j)달 이전에 납부한 금액을 의미
 * 	payments[i][11]은 (i + 1)번 고객이 이번 달에 납부한 금액을 의미
 *  멤버십에 가입하지 않은 기간에도 금액을 납부할 수 있으며, 해당 금액도 연간 납부 금액에 포함
 * estimates[i]는 (i + 1)번 고객이 다음 달에 납부할 납부 예정 금액.
 */
public class MembershipVIP {

	public static void main(String[] args) {

//		// 고객들의 가입 기간을 담은 1차원 정수 배열
//		int[] periods = { 8, 23, 24 };
//		// 고객들의 납부 내역을 담은 2차원 정수 배열
//		int[][] payments = {
//				{ 100000, 100000, 100000, 100000, 100000, 100000, 100000, 100000, 100000, 100000, 100000, 100000 },
//				{ 100000, 100000, 100000, 100000, 100000, 100000, 100000, 100000, 100000, 100000, 100000, 100000 },
//				{ 350000, 50000, 50000, 50000, 50000, 50000, 50000, 50000, 50000, 50000, 50000, 50000 } };
//		// 고객들의 납부 예정 금액을 담은 1차원 정수 배열
//		int[] estimates = { 100000, 100000, 100000 };

		// 가입 기간(4명의 정보)
		int[] periods = { 24, 59, 59, 60 };
		// 4명이 12개월 동안 납부한 금액
		int[][] payments = { { 50000, 50000, 50000, 50000, 50000, 50000, 50000, 50000, 50000, 50000, 50000, 50000 },
				{ 50000, 50000, 50000, 50000, 50000, 50000, 50000, 50000, 50000, 50000, 50000, 50000 },
				{ 350000, 50000, 50000, 50000, 50000, 50000, 50000, 50000, 50000, 50000, 50000, 50000 },
				{ 50000, 50000, 50000, 50000, 50000, 50000, 50000, 50000, 50000, 50000, 50000, 50000 } };
		// 4명이 다음 달에 납부할 예정 금액
		int[] estimates = { 350000, 50000, 40000, 50000 };

		int[] result = new MembershipVIP().solution(periods, payments, estimates);
		System.out.println(Arrays.toString(result));

	}

	private int[] solution(int[] periods, int[][] payments, int[] estimates) {
		// result[0] : 이번 달에 VIP가 아니지만, 다음 달에 VIP가 되는 고객 수
		// result[1] : 이번 달에 VIP지만 다음 달에 VIP가 아닌 고객 수
		int[] result = new int[2]; // 자동 초기화됨 { 0, 0 }
		
		// 12개월 동안 납부한 금액
		for (int i = 0; i < periods.length; i++) {
			// 이번 달
			int thisMonthTotal = 0;
			for (int j = 0; j < payments[i].length; j++) {
				thisMonthTotal += payments[i][j];
			}
			// 이번 달 VIP인지 확인
			boolean isVip1 = isVip(periods[i], thisMonthTotal);
			
			// 다음 달
			int nextMonthTotal = 0;
			// 다음 달에 납부할 금액 estimates 더해주고, 납부한 12개월 중 맨 처음 달 금액 빼주어야 함
			nextMonthTotal = thisMonthTotal + estimates[i] - payments[i][0];
			// 다음 달 VIP인지 확인
			boolean isVip2 = isVip(periods[i] + 1, nextMonthTotal);
			
			if (!isVip1 && isVip2) { // 이번 달에 VIP가 아니지만, 다음 달에 VIP가 되는 고객 수 계산
				result[0]++;
			} else if (isVip1 && !isVip2) { // 이번 달에 VIP지만 다음 달에 VIP가 아닌 고객 수 계산
				result[1]++;
			}
		}
		
		return result;
	}

	private boolean isVip(int periods, int total) {
		if (periods >= 5 * 12) { // 가입 기간 5년 이상
			if (total >= 600000) { // 연간 납부 금액 60만원 이상
				return true; // VIP
			}
		} else if (periods >= 24) { // 가입 기간 2년 이상
			if (total >= 900000) { // 연간 납부 금액 90만원 이상
				return true; // VIP
			}
		}
		
		return false; // 위 조건 둘 다 아니면 VIP 아님
	}

}
