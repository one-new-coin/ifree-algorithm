package com.ifree.algorithm.socket.nio;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

import org.junit.Test;

public class NioServerTest {

	@Test
	public void server() throws Exception {
		ServerSocketChannel server = ServerSocketChannel.open();
		//切换为非阻塞模式
		SocketChannel socketChannel = server.bind(new InetSocketAddress(8888)).accept();
		System.out.println("连接成功！");
		ByteBuffer buffer = ByteBuffer.allocate(1024);
		
		FileChannel fileChannel = FileChannel.open(Paths.get("10.txt"), StandardOpenOption.WRITE,StandardOpenOption.CREATE);
		
		while(socketChannel.read(buffer) != -1) {
			buffer.flip();
			fileChannel.write(buffer);
			buffer.clear();
		}
	}
}
