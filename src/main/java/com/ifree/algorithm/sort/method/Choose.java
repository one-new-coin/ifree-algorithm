package com.ifree.algorithm.sort.method;

import com.ifree.algorithm.sort.TestMethod;

public class Choose implements TestMethod{

	
	public void sort(int[] arr) {
		
		for(int i = 0 ;i < arr.length;i++) {
			int index = i;
			int temp = arr[i];
			
			for(int j = i; j < arr.length;j++) {
				if(arr[j] < temp) {
					index = j;
				}
			}
			
			arr[i] = arr[index];
		}
	}
}
