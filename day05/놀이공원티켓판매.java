package com.shinhan.day05;

import java.util.Arrays;

/*
 * 1. 회원 등급이 높은 사람에게 먼저 티켓을 판매합니다.
 * 2. 회원 등급이 같은 사람들 사이에서는, 더 많은 티켓을 신청한 사람에게 먼저 판매합니다.
 * 3. 단, 남은 티켓의 수보다 더 많은 티켓을 구매하려는 사람에게는 판매하지 않습니다.
 * 
 * 티켓 판매는 한 번에 한 사람씩 순서대로 이루어지며, 등급은 낮은 숫자가 더 높은 등급을 의미합니다.
 * 예를 들어, 1등급이 2등급보다 더 높은 등급입니다.
 * 
 * 한정된 티켓의 개수 tickets와 티켓을 구매하려는 사람들이 담긴 배열 requests가 매개변수로 주어질 때,
 * 판매된 총 티켓 수를 return 하도록 solution 함수를 완성해주세요.
 * 
 * 제한사항
 * - tickets는 1 이상 1,000,000 이하인 정수입니다.
 * - requests의 길이(행의 개수)는 1 이상 100,000 이하입니다.
 * - requests의 각 행은 티켓을 구매하려는 사람의 정보가 [회원 등급, 구매할 티켓 수] 순으로 담겨있습니다.
 * - 회원 등급은 1 이상 10 이하인 자연수입니다.
 * - 구매할 티켓 수는 1 이상 10,000 이하인 자연수입니다.
 * 
 * 입출력 예
 * tickets     requests                            result
 * 10          [[2,3],[1,7],[2,4],[3,5]]           10
 * 8           [[1,9],[3,6],[2,5]]                 5
 * 20000       [[3,1],[2,5],[2,10],[3,8],[1,2]]    26
 * 
 * 입출력 예 #1
 * - 초기 잔여 티켓은 10장입니다. 구매 요청은 1등급에서 7개, 2등급에서 3개와 4개, 그리고 3등급에서 5개가 들어왔습니다.
 * 회원 등급     구매하려는 티켓 수     현재 남은 티켓 수     설명
 * 1           7                  10                회원 등급이 가장 높은 1등급 회원에게 티켓을 7장 판매합니다.
 * 2           4                  3                 다음으로 회원 등급이 높은 2등급 회원에게 티켓을 판매합니다.
 *                                                  이때, 남은티켓 수 보다 더 많은 티켓을 구매하려 하기 때문에,
 *                                                  티켓을 판매하지 않습니다.
 * 2           3                  3                 마찬가지로 2등급 회원에게 티켓을 판매합니다. 남은 티켓만큼 판매할 수 있습니다.
 * 3           5                  0                 남은 티켓이 없으므로 표를 판매할 수 업습니다.
 */
public class 놀이공원티켓판매 {

	public static void main(String[] args) {
		
		// 한정된 티켓의 개수 (1 <= tickets <= 1000000)
		int[] tickets = { 10, 8, 20000 };
		// 티켓을 구매하려는 사람들이 담긴 배열 (1 <= requests.length <= 1000000)
		int[][][] requests = { { { 2, 3 }, { 1, 7 }, { 2, 4 }, { 3, 5 } }, 
				{ { 1, 9 }, { 3, 6 }, { 2, 5 } },
				{ { 3, 1 }, { 2, 5 }, { 2, 10 }, { 3, 8 }, { 1, 2 } } };

		for (int testcast = 0; testcast < tickets.length; testcast++) {
			System.out.println("-------------------testcast[" + testcast + "]");
			int result = solution(tickets[testcast], requests[testcast]);
			System.out.println(result);
			 
			   for(int[] arr:requests[testcast]) { 
				   System.out.println(Arrays.toString(arr));
			 }			 
		}
		
    }

    static int solution(int tickets, int[][] requests) {
    	
    	Arrays.sort(requests, (a, b) -> a[0] - b[0] == 0 ? b[1] - a[1] : a[0] - b[0]);
    	
    	int answer = 0;
    	
    	for (int[] arr : requests) {
    		if (tickets >= arr[1]) {
    			answer += arr[1];
    			tickets -= arr[1];
    		}
    	}
    	
    	return answer;

    }

    private static boolean check(int tickets, int[][] requests) {
        if (tickets < 1 || tickets > 1000000) {
            return false;
        } else if (requests.length < 1 || requests.length > 100000) {
            return false;
        }

        return true;
    }

}
