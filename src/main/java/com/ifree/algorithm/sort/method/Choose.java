package com.ifree.algorithm.sort.method;

import com.ifree.algorithm.sort.TestMethod;

/**
 * @author fengyupeng
 * 
 * 选择排序：
 * 1、定义一个临时存放数据的变量，和一个下标变量index
 * 2、用当前变量和其他数组数据进行比较，如果小于当前变量，记录当前数据的位置
 * 3、交换最后index和当前比较数据的位置
 * 4、依次轮训，知道结束，
 */
public class Choose implements TestMethod{

	@Override
	public void sort(int[] arr) {
		for(int i = 0;i < arr.length;i++) {
			int temp = arr[i],index = i;
			for(int j = i;j < arr.length;j++) {
				if(temp > arr[j]) {
					index = j;
					temp = arr[j];
				}
			}
			
			if(index != i) {
				temp = arr[i];
				arr[i] = arr[index];
				arr[index] = temp;
			}
		}
	}
}
