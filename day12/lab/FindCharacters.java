package com.shinhan.day12.lab;

/*
 * <<처리 결과>>
 * 입력 스트링 : String s  = ”Boys, be ambitious”;
 * a. c = ’i’ 인 경우  =>  2 리턴
 * b. c = ’b’ 인 경우  =>  2 리턴 (B와 b는 서로 다르므로 다른 것으로 간주)
 * 
 * 참고 및 주의사항 :
 * - String 클래스의 toCharArray() 메쏘드를 활용할 수 있습니다. (필수 아님)
 * - 테스트 목적으로 스스로 main을 구현할 수 있습니다.
 * - main 메소드의 내용은 채점하지 않습니다.
 * - 주어진 메소드의 signature는 변경하지 않습니다.
 */
public class FindCharacters {

	public static void main(String[] args) {
		FindCharacters fc = new FindCharacters();
		
		int count = fc.countChar("Boys, be ambitious", 'b');
		
		System.out.println(count);
	}

	/*
	 * int countChar(String str, char c)
	 * - 문자열의 각 내용들을 비교하여 입력받는 char c의 값과 동일한 char의 개수를 리턴한다.
	 * - 대소문자는 각각 다른 것으로 간주한다.
	 */
	public int countChar(String str, char c) {
		int count = 0;
		char[] arr = str.toCharArray();
		
		for (char ch : arr) {
			if (ch == c) {
				count++;
			}
//			if (Character.toLowerCase(c) == Character.toLowerCase(ch)) {
//				count++;
//			}
		}
		
		return count;
	}

}
