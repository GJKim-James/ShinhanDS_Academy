package com.shinhan.day08.lab;

public class Radio implements Volume {
	
	int volLevel;

	// VolLevel 을 주어진 level 만큼 증가, 메시지 출력
	@Override
	public void volumeUp(int level) {
		this.volLevel += level;

		System.out.println(getClass().getSimpleName() + "볼륨 올립니다." + volLevel);
	}

	// VolLevel 을 주어진 level 만큼 감소, 메시지 출력
	@Override
	public void volumeDown(int level) {
		this.volLevel -= level;

		System.out.println(getClass().getSimpleName() + "볼륨 내립니다." + volLevel);
	}

}
