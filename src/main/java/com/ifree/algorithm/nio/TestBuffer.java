package com.ifree.algorithm.nio;

import java.nio.ByteBuffer;

import org.junit.Test;


/**
 * 
 * @ClassName: TestBuffer
 * @Description: TODO
 * @author fypeng
 * @date 2019年7月13日
 *
 *
 *put() ：存入数据到缓冲区中
 *get() : 获取缓冲区中数据
 *
 * 0 <= mark <= position  <= limit <= capacity
 * 
 * capacity:缓冲区中最大的容量，一旦声明不能改变
 * limit:表示缓冲区中可以操作数据的大小
 * position:表示一个正在操作数据位置型指针
 * mark：当前position的位置标记（配合reset使用）
 * 
 * 
 * 缓冲区：直接缓冲区和非直接缓冲区
 * 非直接缓冲区：allocate => 在JVM中
 * 直接缓冲区： allocateDirect() => 在内存中
 */
public class TestBuffer {

	
	@Test
	public void test() {
		
		String val = "abcde";
		ByteBuffer buf = ByteBuffer.allocate(1024);

		System.out.println("init:");
		printVal(buf);
		System.out.println("传输数据后：");
		buf.put(val.getBytes());
		printVal(buf);
		
		//切换读取数据模式
		System.out.println("切换读取数据模式后：");
		buf.flip();
		printVal(buf);
		byte[] dst = new byte[buf.limit()];
		buf.get(dst);
		System.out.println(new String(dst,0,dst.length));
		printVal(buf);
		
		//清空缓冲区
		buf.clear();
		printVal(buf);
	}
	
	private void printVal(ByteBuffer buf) {
		System.out.println("capacity:"+buf.capacity());
		System.out.println("limit:"+buf.limit());
		System.out.println("position:"+buf.position());
		//System.out.println("mark:"+buf.mark());
	}
}
