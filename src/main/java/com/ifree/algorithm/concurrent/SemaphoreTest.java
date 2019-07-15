package com.ifree.algorithm.concurrent;

import java.util.concurrent.Semaphore;

/**
 * 
 * @author fengyupeng
 * 限制线程的并发数量
 * permits:允许，最多允许多少个线程同时执行acquire和release之间的代码,该类不能宝成线程安全性。
 * 
 */
public class SemaphoreTest {

	//permits:允许的许可
	private Semaphore semaphore = new Semaphore(1);
	
	public void testMethod() {
		try {
			semaphore.acquire();
			System.out.println(Thread.currentThread().getName() + "-begin timer = " + System.currentTimeMillis());
			Thread.sleep(5000);
			System.out.println(Thread.currentThread().getName() + "-end timer = " + System.currentTimeMillis());
			semaphore.release();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	
	public static void main(String[] args) {
		final SemaphoreTest st = new SemaphoreTest();
		new Thread(()->{
			st.testMethod();
		},"A").start();		
		new Thread(()->{
			st.testMethod();
		},"B").start();	
		new Thread(()->{
			st.testMethod();
		},"C").start();	
	}
}
