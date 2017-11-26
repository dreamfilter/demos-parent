package com.threads.demo;

class A {
	public void request() {
		System.out.println("Hi B,I need your source D...");
	}

	public void get() {
		System.out.println("A had D...");
	}

}

class B {
	public void request() {
		System.out.println("Hi A,I need your source C...");
	}

	public void get() {
		System.err.println("B had C...");
	}
}

public class ThreadDeadLock implements Runnable {
	private static A a = new A();
	private static B b = new B();
	private boolean flag = false;

	public static void main(String[] args) {
		ThreadDeadLock deadLock1 = new ThreadDeadLock();
		ThreadDeadLock deadLock2 = new ThreadDeadLock();
		deadLock1.flag = true;
		deadLock2.flag = false;
		Thread threadA = new Thread(deadLock1);
		Thread threadB = new Thread(deadLock2);
		threadA.start();
		threadB.start();
	}

	public void run() {
		if (flag) {
			synchronized (a) {
				a.request();
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				synchronized (b) {
					a.get();
				}

			}
		} else {
			b.request();
			synchronized (b) {
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			synchronized (a) {
				b.get();
			}
		}

	}

}
