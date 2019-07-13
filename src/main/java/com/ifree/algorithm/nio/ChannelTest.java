package com.ifree.algorithm.nio;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileChannel.MapMode;
import java.nio.charset.Charset;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Map;

import org.junit.Test;


/**
 *
 * @ClassName: ChannelTest
 * @Description: 
 *  Channel 用于source -> target 的连接，在Java Nio中负责缓冲区中数据传输
 *  
 *  主要实现类：java.nio.channels.Channel 接口：
 *   FileChannel
 *   SocketChannel
 *   ServerSocketChannel
 *   DatagramChannel
 *   
 *   获取通道:
 *   1、getChannel()
	 *   FileInputStream()/FileOutputStream()
	 *   RandomAccessFile
	 *   
	 *   网络IO:
	 *   Socket
	 *   ServerSocket
	 *   DatagramSocket
	 2、jdk1.7后NIO2 针对各个通道提供了静态方法open()
	 3、jdk1.7 中NIO2的Files工具类的newByteChannel()
	 
	四、通道之间的数据传输
	transferFrom()
	transferTo()
 * @author fypeng
 * @date 2019年7月13日
 *
 */
public class ChannelTest {

	
	/**
	 * 
	* @Title: test5
	* @Description: 
	* 
	* 字符集：Charset
	* 
	* @param     参数
	* @return void    返回类型
	* @throws
	 */
	@Test
	public void test5() {
		Map<String,Charset> map = Charset.availableCharsets();
		map.forEach((e,v)->{
			System.out.println(e+":"+v);
		});
	}
	
	
	/**
	 *
	* @Title: test4
	* @Description: 
	* 分散和聚集（Scatter和 Gather)
	* 分散读取：将通道中的数据分散到多个缓冲区中
	* 聚集写入：将多个缓冲数据聚集到通道中
	* 
	* @param     参数
	* @return void    返回类型
	* @throws
	 */
	@Test
	public void test4()throws Exception {
		RandomAccessFile file = new RandomAccessFile("1.txt", "rw");
		FileChannel fc = file.getChannel();
		
		
		ByteBuffer b1 = ByteBuffer.allocate(10);
		ByteBuffer b2 = ByteBuffer.allocate(20);
		
		ByteBuffer[] dsts = {b1,b2};
		fc.read(dsts);
		
		//打印dsts
		System.out.println(new String(dsts[0].array(),0,dsts[0].limit()));
		System.out.println(new String(dsts[1].array(),0,dsts[1].limit()));
		
		
		
		//聚集
		b1.flip();
		b2.flip();
		RandomAccessFile gather = new RandomAccessFile("7.txt","rw");
		FileChannel fc1 = gather.getChannel();
		fc1.write(dsts);
		
		fc.close();
		fc1.close();
		file.close();
		gather.close();
	}
	
	
	
	//通道之间直接传输 (直接缓冲的方式)
	@Test
	public void test3()throws Exception{
		FileChannel inChannel =FileChannel.open(Paths.get("1.txt"), StandardOpenOption.READ);
		FileChannel outChannel = FileChannel.open(Paths.get("6.txt"), StandardOpenOption.WRITE,StandardOpenOption.READ,StandardOpenOption.CREATE);
		
		//inChannel.transferTo(0, inChannel.size(), outChannel);
		outChannel.transferFrom(inChannel, 0, inChannel.size());
		
		inChannel.close();
		outChannel.close();
		
	}
	
	
	//使用直接缓冲区完成文件的复制(内存映射文件)
	@Test
	public void test2() throws Exception {
		FileChannel inChannel =FileChannel.open(Paths.get("1.txt"), StandardOpenOption.READ);
		FileChannel outChannel = FileChannel.open(Paths.get("4.txt"), StandardOpenOption.WRITE,StandardOpenOption.READ,StandardOpenOption.CREATE);
		
		MappedByteBuffer inBuf = inChannel.map(MapMode.READ_ONLY, 0, inChannel.size());
		
		MappedByteBuffer outBuf = outChannel.map(MapMode.READ_WRITE, 0, inChannel.size());
		
		byte[] buffer = new byte[inBuf.limit()];
		
		inBuf.get(buffer);
		outBuf.put(buffer);
		
		inChannel.close();
		outChannel.close();
		
	}
	

	//利用通道完成文件复制
	@Test
	public void test1() {
		FileInputStream fis = null;
		FileOutputStream fos = null;
		FileChannel inChannel = null;
		FileChannel outChannel = null;
		
		try {
			fis = new FileInputStream("1.txt");
			fos = new FileOutputStream("3.txt");
			
			inChannel = fis.getChannel();
			outChannel = fos.getChannel();
			
			ByteBuffer buffer = ByteBuffer.allocate(1024);
			
			while(inChannel.read(buffer) != -1) {
				buffer.flip();
				outChannel.write(buffer);
				buffer.clear();
			}
			
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			
			if(outChannel != null) {
				try {
					outChannel.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			
			if(inChannel != null) {
				try {
					inChannel.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			
			if(fis != null) {
				try {
					fis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			
			if(fos != null) {
				try {
					fos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	
}
