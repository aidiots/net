package com.yc.net;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server2 {
	public static void main(String[] args) throws IOException {
		ServerSocket ssk=new ServerSocket(6868);
		System.out.println("服务器已启动，等待客户端连接...");
		
		Socket sk=ssk.accept();		//等待接收客户端的连接，这是一个阻塞式方法
		
		BufferedReader read=new BufferedReader(new InputStreamReader(sk.getInputStream()));
		PrintWriter pw=new PrintWriter(sk.getOutputStream());
		
		BufferedReader sc=new BufferedReader(new InputStreamReader(System.in));
		
		System.err.println("客户端问:"+read.readLine());
		System.out.println("请输入您的回答:");
		String line=sc.readLine();
		
		while(!"bye".equals(line)){
			pw.println(line);
			pw.flush();
			
			line=read.readLine();
			if("bye".equals(line)){
				break;
			}
			
			System.out.println("客户端问:"+line);
			System.out.println("请输入您的回答:");
			line=sc.readLine();
		}
		pw.println(line);
		pw.flush();
		
		read.close();
		pw.close();
		sc.close();
		
		sk.close();
		ssk.close();
	}
}
