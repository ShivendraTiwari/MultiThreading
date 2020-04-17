package com.shivendra.multiThreading;

class Counter2 extends Thread {

	private int currentValue;

	public Counter2(String threadName) {
		super(threadName);
		currentValue = 0;
		System.out.println(this);
		start();
	}

	public int getValue() {
		return currentValue;
	}

	public void run() {
		try {
			while (currentValue < 5) {
				System.out.println(getName() + ":" + (currentValue++));
				Thread.sleep(250);
			}
		} catch (InterruptedException e) {
			System.out.println(getName() + "Interrupted");
		}
		System.out.println("Exit from Thread: " + getName());
	}
}

public class MuthreadingThroughThread {

	public static void main(String[] args) {

		System.out.println("Method main() runs in Thread " + Thread.currentThread().getName());
		Counter2 counterA = new Counter2("Counter A");
		Counter2 counterB = new Counter2("Counter B");

		System.out.println("Exit from main() method");
	}

}
