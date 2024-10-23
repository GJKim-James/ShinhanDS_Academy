package com.shinhan.day15.exam;

public class Prob2 {

	public static void main(String[] args) throws IllegalSizeException {
		System.out.println(leftPad("Samsung", 10, '#'));
		System.out.println(leftPad("SDS", 5, '*'));
		System.out.println(leftPad("Multicampus", 5, '@'));
	}

	public static String leftPad(String str, int size, char fillChar) {
		String result = "";

		try {
			if (size < str.length()) {
				throw new IllegalSizeException("문자열의 길이가 size보다 큽니다.");
			}
		} catch (IllegalSizeException e) {
			return e.getMessage();
		}

		StringBuilder sb = new StringBuilder();

		for (int i = 1; i <= size - str.length(); i++) {
			sb.append(fillChar);
		}

		result = sb + str;

		return result;
	}

}

class IllegalSizeException extends Exception {
	IllegalSizeException(String message) {
		super(message);
	}
}