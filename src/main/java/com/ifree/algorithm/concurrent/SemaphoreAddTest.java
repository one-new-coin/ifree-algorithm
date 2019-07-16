package com.ifree.algorithm.concurrent;

import java.util.concurrent.Semaphore;

public class SemaphoreAddTest {

	/**
	 * 多次调用Semaphore类的release()和release()方法时，还可以动态增加permits的个数
	 * @param args
	 */
	public static void main(String[] args) {
		
		try {
			Semaphore semaphore = new Semaphore(5);
			
			semaphore.acquire();
			semaphore.acquire();
			semaphore.acquire();
			semaphore.acquire();
			semaphore.acquire();
			
			System.out.println(semaphore.availablePermits());
			
			semaphore.release();
			System.out.println(semaphore.availablePermits());
			semaphore.release();
			semaphore.release();
			semaphore.release();
			semaphore.release();
			System.out.println(semaphore.availablePermits());
			semaphore.release();
			System.out.println(semaphore.availablePermits());
			semaphore.release(4);
			System.out.println(semaphore.availablePermits());
		}catch (Exception e) {
		}
		
	}
}
