package com.ifree.algorithm.sort.method;

import com.ifree.algorithm.sort.TestMethod;

/**
 * 冒泡排序
 * @author fengyupeng
 *
 */
public class Bubble implements TestMethod{

	@Override
	public void sort(int[] arr) {
		for(int i = 0;i < arr.length;i++) {
			for(int j = 0; j < arr.length;j++) {
				int temp = 0;
				if(arr[i] < arr[j]) {
					temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}
		}
	}
	
}
