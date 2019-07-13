package com.ifree.algorithm.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Date;

public class TimeServerHandler implements Runnable{

	
	public Socket socket;
	
	public TimeServerHandler(Socket socket) {
		this.socket = socket;
	}
	
	@Override
	public void run() {
		BufferedReader in = null;
		PrintWriter out = null;
		
		try {
			in = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
			out = new PrintWriter(this.socket.getOutputStream(),true);
			String body = null;
			while((body = in.readLine()) != null && body.length() != 0) {
				System.out.println("读取数据:"+body);
				out.print(new Date().toString());
			}
		}catch (Exception e) {
			
		}finally {
			if(in != null) {
				try {
					in.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			
			if(out != null) {
				out.close();
			}
			
			if(this.socket != null) {
				try {
					this.socket.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

}
