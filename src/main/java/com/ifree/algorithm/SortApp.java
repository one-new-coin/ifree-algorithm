package com.ifree.algorithm;

import java.util.Arrays;

import com.ifree.algorithm.sort.CommonTest;
import com.ifree.algorithm.sort.method.Bubble;

public class SortApp {

	public static void main(String[] args) {
		int[] arr = CommonTest.randomArr(10);
		System.out.println("----排序前："+ Arrays.toString(arr));
		CommonTest.common(arr,"冒泡排序",new Bubble(),true);
//		CommonTest.common(arr,"选择排序",new Choose(),true);
//		CommonTest.common(arr,"插入排序",new Insert(),true);
//		CommonTest.common(arr, "希尔排序",new Shell(),true);		
//		CommonTest.common(arr, "希尔排序",new Shell(),true);
//		CommonTest.common(arr, "快速排序",new Fast(),true);
//		CommonTest.common(arr, "归并排序",new Merge(),true);
		
	}
}
