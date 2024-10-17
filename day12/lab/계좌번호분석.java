package com.shinhan.day12.lab;

import java.util.Arrays;
import java.util.HashMap;

/*
 * 다수의 계좌번호가 주어졌을 때, 정상 계좌번호를 추려내고,
 * 계좌번호의 형태를 분석해서 은행별로 몇 개의 계좌번호가 존재하는 구하려고 합니다.
 * 
 * 은행 계좌번호는 다음과 같은 규칙을 가집니다.
 * 규칙 1) 계좌번호는 0 ~ 9 사이의 숫자와 특수문자 -로만 이루어집니다.
 * 규칙 2) 계좌번호에 포함된 숫자의 개수는 11개 이상 14개 이하입니다.
 * 규칙 3) 계좌번호에 포함된 -의 개수는 0개 이상 3개 이하입니다.
 * 규칙 4) 계좌번호에 포함된 -는 연속해서 나타날 수 없고, 계좌번호의 처음이나 마지막 자리에 나타날 수 없습니다.
 * 
 * 또한, 두 개의 계좌번호를 비교했을 때, 아래의 조건을 만족하면 같은 은행의 계좌번호로 판단합니다.
 * 조건) 계좌번호에 포함된 숫자와 -의 개수가 모두 같고, -의 위치가 같다면 같은 은행의 계좌번호입니다.
 */
public class 계좌번호분석 {

	public static void main(String[] args) {
		String[] accounts = { "4514--234495-1", "305-44-291501", "1-2-34-495-8623", "492134545151", "623-421523-67-341",
				"-5439-59639921", "6235-7X3+47-7456", "98-76-543-210", "512-73-634901", "000-999999-22-555",
				"064-82-792561" };

		solution(accounts);

//		계좌번호분석 e = new 계좌번호분석();
//
//		int[] result = e.solution(new String[] { "4514--234495-1", "305-44-291501", "1-2-34-495-8623", "492134545151",
//				"623-421523-67-341", "-5439-59639921", "6235-7X3+47-7456", "98-76-543-210", "512-73-634901",
//				"000-999999-22-555", "064-82-792561" });
//
//		int[] result = e.solution(new String[] { "1-2-3-456789012", "582845-385823", "48572-39485-89012",
//				"4-5-2-593328484", "4958-39-2945123-", "49582039415423", "7-3-7-000000000", "485723-693812",
//				"39482746582734", "1-1-1-111111111", "A4944-5095-4951", "4851293412223" });
//		
//		int[] result = e.solution(new String[] { "592356=5345", "49-694-4495-64", "5923565345%" });
//		
//		System.out.println(Arrays.toString(result));
	}

	private static void solution(String[] accounts) {
		HashMap<String, Integer> map = new HashMap<>();

		for (String acc : accounts) {
			// 1. 정상 계좌번호인지
			if (!isValid(acc)) {
				continue;
			}

			// 2. 같은 은행 계좌인지? 패턴이 같으면 같은 은행, 개수
			String bankName = getBankName(acc);
			System.out.println(acc + " : " + bankName);
			map.put(bankName, map.getOrDefault(bankName, 0) + 1);
		}
		System.out.println("----------------------------------------");

		System.out.println(map);
	}

	private static String getBankName(String acc) {
		// 623-421523-67-341
		// => 3-6-2-3(숫자 개수로 구분)
		StringBuilder sb = new StringBuilder();
		String[] arr = acc.split("-");

		for (String s : arr) {
			sb.append(s.length() + "-");
		}

		return sb.toString();
	}

	private static boolean isValid(String acc) {
		// 규칙 1) 숫자와 '-' 만 포함(정규표현식으로 작성)
		if (!acc.matches("[0-9-]+"))
			return false;
		
		// 규칙 2) 숫자는 11개 이상 14개 이하
		long count = acc.chars().filter(c -> Character.isDigit(c)).count();
		if (count < 11L || count > 14L) {
			return false;
		}

		// 규칙 3, 4 : '-'는 0개 이상 3개 이하, 연속하지 않음, 시작과 끝에 없음
		long dashCount = acc.chars().filter(c -> c == '-').count();
		if (dashCount < 0 || dashCount > 3) {
			return false;
		}

		if (acc.contains("--") || acc.startsWith("-") || acc.endsWith("-")) {
			return false;
		}
		
		return true;
	}

}
