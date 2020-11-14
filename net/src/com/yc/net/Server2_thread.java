package com.yc.net;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server2_thread {
	public static void main(String[] args) throws IOException {
		ServerSocket ssk=new ServerSocket(6868);
		System.out.println("服务器已启动，等待客户连接...");
		
		Socket sk=null;
		
		while(true){
			sk=ssk.accept();	//等待接收客户的连接，这是一个阻塞式方法
			new Thread( new MyClient(sk)).start();
		}
	}
}	

class MyClient implements Runnable{
	private Socket sk=null;
	
	public MyClient(Socket sk){
		this.sk=sk;
	}
	
	@Override
	public void run() {
		BufferedReader read=null;
		PrintWriter pw=null;
		BufferedReader sc=null;
		
		try {
			read=new BufferedReader(new InputStreamReader(sk.getInputStream()));
			pw=new PrintWriter(sk.getOutputStream());
			sc=new BufferedReader(new InputStreamReader(System.in));
			
			System.out.println("客户端问："+read.readLine());
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
		} catch (IOException e) {
			e.printStackTrace();
		} finally{
			if(read!=null){
				try {
					read.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if(pw!=null){
				pw.close();
			}
			if(sc!=null){
				try {
					sc.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if(sk!=null){
				try {
					sk.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
}
