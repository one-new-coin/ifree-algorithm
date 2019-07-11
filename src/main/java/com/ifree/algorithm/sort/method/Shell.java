package com.ifree.algorithm.sort.method;

import com.ifree.algorithm.sort.TestMethod;


/**
 * 希尔排序
 * @author fengyupeng
 *
 */
public class Shell implements TestMethod{

	//2,3,654,21,43,234,22,121,32,22
	@Override
	public void sort(int[] arr) {
		int len = arr.length;
		int temp = 0;
		int gap = len / 2;
		while(gap > 0) {
			for(int i = gap;i < len;i++) {
				for(int j = i - gap; j >=0;j -= gap) {
					if(arr[j] > arr[j + gap]) {
						temp = arr[j];
						arr[j] =  arr[j+gap];
						arr[j+gap] = temp;
					}
				}
			}
			gap /= 2;
		}
		
	}

}
