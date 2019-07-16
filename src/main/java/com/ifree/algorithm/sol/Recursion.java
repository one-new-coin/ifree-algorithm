package com.ifree.algorithm.sol;

public class Recursion {

	
	public static long val(long n) {
		if(n == 0 || n == 1) {
			return 1;
		}
		return val(n - 1) + n;
	}
	
	public static void main(String[] args) {
		System.out.println(val(100));
	}
}
