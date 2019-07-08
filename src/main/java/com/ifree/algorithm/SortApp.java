package com.ifree.algorithm;

import com.ifree.algorithm.sort.CommonTest;
import com.ifree.algorithm.sort.method.Bubble;
import com.ifree.algorithm.sort.method.Choose;
import com.ifree.algorithm.sort.method.Insert;

public class SortApp {

	public static void main(String[] args) {
		int[] arr = CommonTest.randomArr(20);
		CommonTest.common(arr,"冒泡排序",new Bubble());
		CommonTest.common(arr,"选择排序",new Choose());
		CommonTest.common(arr,"插入排序",new Insert());
	}
}
