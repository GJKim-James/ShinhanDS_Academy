package com.shinhan.day08.lab;

public class Speaker implements Volume {

	int volLevel;

	// VolLevel 을 주어진 level 만큼 증가, 메시지 출력, 100보다 크면 100으로 설정
	@Override
	public void volumeUp(int level) {
		this.volLevel += level;

		if (volLevel > 100) {
			volLevel = 100;
		}

		System.out.println(getClass().getSimpleName() + "볼륨 올립니다." + volLevel);
	}

	// VolLevel 을 주어진 level 만큼 감소, 메시지 출력, 값이 0보다 작으면 0으로 설정
	@Override
	public void volumeDown(int level) {
		this.volLevel -= level;

		if (volLevel < 0) {
			volLevel = 0;
		}

		System.out.println(getClass().getSimpleName() + "볼륨 내립니다." + volLevel);
	}

}
