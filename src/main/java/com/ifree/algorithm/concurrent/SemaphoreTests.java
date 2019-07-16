package com.ifree.algorithm.concurrent;

import java.util.concurrent.Semaphore;

public class SemaphoreTests {

	Semaphore s = new Semaphore(10);
	
	
	public void testMethod() {
		try {
			
			s.acquire(2);
			
			Thread.sleep(5000);
			
			System.out.println(s.availablePermits() +":"+ Thread.currentThread().getName() + "-线程:" + System.currentTimeMillis());
			
			s.release(2);
			
		}catch (Exception e) {
		}
	}
	
	public static void main(String[] args) {
		SemaphoreTests ts = new SemaphoreTests();
		for(int i = 0;i < 10;i++) {
			new Thread(()->{
				ts.testMethod();
			},(i+1) + "").start();
		}
	}
}
