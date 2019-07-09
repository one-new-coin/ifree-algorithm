package com.ifree.algorithm.design.single;


/**
 * 恶汉式
 * @author fengyupeng
 *
 */
public class Single {

	private static final Single s = new Single();
	
	private Single() {
		
	}
	public static final Single build() {
		return s;
	}
}
