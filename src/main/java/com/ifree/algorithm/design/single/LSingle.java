package com.ifree.algorithm.design.single;

/**
 * 懒汉式，线程不安全
 * @author fengyupeng
 *
 */
public class LSingle {

	
	private final static LSingle s = null;
	
	private LSingle() {
	
	}
	
	public final static LSingle build() {
		if(s == null) {
			return new LSingle();
		}
		return s;
	}
}
