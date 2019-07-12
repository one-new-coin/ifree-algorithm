package com.ifree.algorithm.io;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.net.ServerSocket;

import org.junit.Test;

public class FileOutputStreamTest {

	
	/**
	 * 
	 * @throws Exception
	 */
	@Test
	public void test1() throws Exception{
		
		File file = new File("2.txt");
		OutputStream os = new FileOutputStream(file);
		String outStr = "This is a test Hello world";
		os.write(outStr.getBytes(),0,outStr.length());
	}
}
