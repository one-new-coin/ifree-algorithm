package com.ifree.algorithm.sort.method;

import com.ifree.algorithm.sort.TestMethod;


/**
 *
 * @author fengyupeng
 * 
 * 插入排序
 * 1、取出数组中第二个元素
 * 2、将第二个元素和前面的元素进行比较，如果小于前面的元素，则进行位置交换
 * 3、依次进行其他元素比较
 *
 */
public class Insert implements TestMethod{
	@Override
	public void sort(int[] arr) {
		for( int i = 1;i < arr.length;i++) {
			int temp = arr[i];
			for(int j = i - 1; j >=0 ;j--) {
				if(temp < arr[j]) {
					arr[j+1] = arr[j];
					arr[j] = temp;
				}
			}
		}
		
	}

}
