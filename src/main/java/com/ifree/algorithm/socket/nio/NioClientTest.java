package com.ifree.algorithm.socket.nio;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.SocketChannel;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

import org.junit.Test;

import lombok.Cleanup;

public class NioClientTest {

	
	@Test
	public void client() throws Exception {
		@Cleanup SocketChannel socketChannel = SocketChannel.open(new InetSocketAddress("localhost",8888));
		
		//切换为非阻塞
		//socketChannel.configureBlocking(false);
		@Cleanup FileChannel inChannel = FileChannel.open(Paths.get("1.txt"), StandardOpenOption.READ);
		
		ByteBuffer buffer = ByteBuffer.allocate(1024);
		
		while(inChannel.read(buffer) != -1) {
			buffer.flip();
			socketChannel.write(buffer);
			buffer.clear();
		}
	}
}
