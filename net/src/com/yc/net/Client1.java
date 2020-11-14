package com.yc.net;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client1 {
	public static void main(String[] args) throws UnknownHostException, IOException {
		Socket sk=new Socket("127.0.0.1",6868);
		
		//通过这个连接对象获取一个输出流，用来向服务器发信息
		DataOutputStream dos=new DataOutputStream(sk.getOutputStream());
		
		//获取一个输入流，用来获取服务器响应的信息
		DataInputStream dis=new DataInputStream(sk.getInputStream());
		
		dos.writeUTF("hello world!我是客户端");
		dos.flush();
		
		// 获取服务器端的相应信息
		String line=dis.readUTF();
		System.out.println(line);
		
		dos.close();
		dis.close();
		sk.close();
	}
}
