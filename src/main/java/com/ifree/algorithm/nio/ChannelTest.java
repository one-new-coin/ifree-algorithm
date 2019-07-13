package com.ifree.algorithm.nio;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileChannel.MapMode;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

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
	 
	 
 * @author fypeng
 * @date 2019年7月13日
 *
 */
public class ChannelTest {
	
	
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
