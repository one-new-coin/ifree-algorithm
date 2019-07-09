package com.ifree.algorithm.design.single;


/**
 * 双重检测
 * @author fengyupeng
 *
 */
public class DoubleSingle {

	private static volatile DoubleSingle ds = null;
	
	private DoubleSingle() {
		
	}
	
	public final static DoubleSingle build() {
		if(ds == null) {
			synchronized (DoubleSingle.class) {
				if(ds == null) {
					ds =  new DoubleSingle();
				}
			}
		}
		return ds;
	}
}
