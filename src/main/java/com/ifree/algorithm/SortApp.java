package com.ifree.algorithm;

import java.util.Arrays;

import com.ifree.algorithm.sort.CommonTest;
import com.ifree.algorithm.sort.method.Bubble;
import com.ifree.algorithm.sort.method.Shell;

public class SortApp {

	public static void main(String[] args) {
		int[] arr = CommonTest.randomArr(10);
		System.out.println("----排序前："+ Arrays.toString(arr));
		CommonTest.common(arr,"冒泡排序",new Bubble());
//		CommonTest.common(arr,"选择排序",new Choose());
//		CommonTest.common(arr,"插入排序",new Insert());
//		CommonTest.common(arr, "希尔排序",new Shell());
//		CommonTest.common(arr, "快速排序",new Fast());
//		CommonTest.common(arr, "归并排序",new Merge());
		CommonTest.common(arr, "希尔排序",new Shell());
	}
}
