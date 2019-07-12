package com.ifree.algorithm.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.junit.Test;

public class FileInputStreamTest {

	
	/**
	 * 文件输入流
	 * @throws IOException
	 * 1、创建一个文件并设置路径
	 * 2、创建一个数据流，将路径地址设置给流中
	 * 3、创建一个buffer数组
	 * 4、将文件内容循环传入到数组中
	 */
	@Test
	public void test() throws IOException {
		final String path = "1.txt";
		File file = new File(path);
		InputStream is = new FileInputStream(file);
		byte[] buff = new byte[1024];
		int len = 0;
		while( (len = is.read(buff)) != -1) {
			System.out.println(new String(buff,"UTF-8"));
		}
		is.close();
	}
}
