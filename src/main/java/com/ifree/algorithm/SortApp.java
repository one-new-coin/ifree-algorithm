package com.ifree.algorithm;

import com.ifree.algorithm.sort.CommonTest;
import com.ifree.algorithm.sort.method.Insert;

public class SortApp {

	public static void main(String[] args) {
		//CommonTest.common(80000,"冒泡排序",new Bubble());
		//CommonTest.common(20,"选择排序",new Choose());
		CommonTest.common(5,"插入排序",new Insert());
	}
}
