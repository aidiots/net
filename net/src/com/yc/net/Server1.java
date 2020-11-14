package com.yc.net;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server1 {
	public static void main(String[] args) throws IOException {
		ServerSocket ssk=new ServerSocket(6868);
		System.out.println("服务器已启动，等待客户端连接...");
		
		Socket sk=null;
		DataInputStream dis=null;
		DataOutputStream dos=null;
		
		sk=ssk.accept();    //等待接收客户端的连接，这是一个阻塞式方法
		System.out.println("客户端:	"+sk.getInetAddress() + "连接上了");
		
		dis=new DataInputStream(sk.getInputStream());
		dos=new DataOutputStream(sk.getOutputStream());
		
		// 获取客户端发送的信息
		System.err.println("客户端问："+dis.readUTF());
		dos.writeUTF("我是张三");
		dos.flush();
		
		dis.close();
		dos.close();
		sk.close();
		ssk.close();
	}
}
