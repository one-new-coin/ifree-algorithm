package com.ifree.algorithm.sort;

import java.security.SecureRandom;
import java.util.Arrays;

public class CommonTest {
	
	public static int[] randomArr(final int count) {
		SecureRandom s = new SecureRandom();
		int[] arr = new int[count];
		for (int i = 0; i < count; i++) {
			arr[i] = s.nextInt(count);
		}
		return arr;
	}
	
	public static void common(final int[] arr,final String name,TestMethod method,boolean flag) {
		long start = System.currentTimeMillis();
		method.sort(arr);
		long end = System.currentTimeMillis();
		if(flag) {
			System.out.println(name + "-后："+ Arrays.toString(arr));
		}
		System.out.println("所需时间:"+ (end-start));
	}
}
