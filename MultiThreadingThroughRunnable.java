package com.shivendra.multiThreading;

class Counter implements Runnable {

	private int currentValue;
	private Thread worker;

	public Counter(String ThreadName) {
		currentValue = 0;
		worker = new Thread(this, ThreadName);
		System.out.println(worker);
		worker.start();
	}

	public int getValue() {
		return currentValue;
	}

	public void run() {
		try {
			while (currentValue < 5) {
				System.out.println(worker.getName() + ":" + (currentValue++));
				Thread.sleep(250);
			}
		} catch (InterruptedException e) {
			System.out.println(worker.getName() + "interrupted");
		}
		System.out.println("Exit from thread: " + worker.getName());
	}
}

public class MultiThreadingThroughRunnable {

	public static void main(String[] args) {
		Counter counterA = new Counter("Counter A");
		try {
			int val;
			do {
				val = counterA.getValue();
				System.out.println("Counter value read by main method:" + val);
				Thread.sleep(1000);
			} while (val < 5);
		} catch (InterruptedException e) {
			System.out.println("main Thread Interrupted");
		}
		System.out.println("Exit from main method");
	}

}
