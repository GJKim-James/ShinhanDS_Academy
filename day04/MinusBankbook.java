package com.shinhan.day04;

public class MinusBankbook {

	public static void main(String[] args) {
		// 마이너스 통장의 한도액을 나타내는 정수 m
        // 고객의 입출금 요청을 담은 정수 배열 ledger
        int m = 5000;
        int[] ledger = { 10000, -13000, -4000, -2000, 6500, -20000 };
        // 입출력 예 1)
        System.out.println(solution(m, ledger));

        int m2 = 34151;
        int[] ledger2 = { -34152, -40000, -50000 };
        // 입출력 예 2)
        System.out.println(solution(m2, ledger2));
	}
	
	private static int solution(int m, int[] ledger) {
        int leftMoney = 0; // 통장 잔고액

        // 제한사항 검사 후 실행
        if (check(m, ledger) == true) {
            for (int money : ledger) {
                if (leftMoney + money < -m) {
//                    System.out.println(money + "(요청 거절)");
                    money = 0; // 요청 거절이므로 입출금에 영향이 없도록 0으로 만들어줌
                } else {
                    leftMoney += money;
                }
            }
        }

        return leftMoney;
    }

    private static boolean check(int m, int[] ledger) {
        if (m < 1000 || m > 500000) {
            System.out.println("한도액 설정을 잘못하셨습니다.");
            System.out.println("1,000 <= m <= 500,000");
            return false;
        } else if (ledger.length < 1 || ledger.length > 100) {
            System.out.println("입출금 요청 횟수 설정을 잘못하셨습니다.");
            System.out.println("1 <= ledger의 길이(입출금 요청 횟수) <= 100");
            return false;
        }
		
		for (int money : ledger) {
            if (Math.abs(money) < 1 || Math.abs(money) > 100000) {
                System.out.println("입출금 요청 금액 설정을 잘못하셨습니다.");
                System.out.println("1 <= ledger의 모든 원소의 절댓값 <= 100,000");
                return false;
            }
        }
        
        return true;
    }

}
