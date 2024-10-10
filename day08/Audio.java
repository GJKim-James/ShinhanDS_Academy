package com.shinhan.day08;

public class Audio implements RemoteControl, RemoteControl2 {

	@Override
	public void turnOn2() {
		System.out.println(getClass().getSimpleName() + " RemoteControl2 turnOn2()");
	}

	@Override
	public void turnOff2() {
		System.out.println(getClass().getSimpleName() + " RemoteControl2 turnOff2()");
	}

	@Override
	public void turnOn() {
		System.out.println(getClass().getSimpleName() + " RemoteControl turnOn()");
	}

	@Override
	public void turnOff() {
		System.out.println(getClass().getSimpleName() + " RemoteControl turnOff()");
	}

}
