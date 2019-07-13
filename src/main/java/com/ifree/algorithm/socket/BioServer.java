package com.ifree.algorithm.socket;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class BioServer {

	
	/**
	 * 
	* @Title: main
	* @Description: 
	* 
	* 1、创建ServerSocket,并监听某个端口
	* 2、通过accept监听事件连接
	* 3、创建线程做Socket循环事件处理
	* 
	* @param @param args    参数
	* @return void    返回类型
	* @throws
	 */
	public static void main(String[] args){
		ServerSocket serverSocket = null;
		try {
			serverSocket = new ServerSocket(8888);
			Socket socket = null;
			
			while(true) {
				socket = serverSocket.accept();
				System.out.println("连接成功！");
				new Thread(new TimeServerHandler(socket)).start();
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(serverSocket != null) {
				try {
					serverSocket.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
	}
}
