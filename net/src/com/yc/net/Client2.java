package com.yc.net;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client2 {
	public static void main(String[] args) throws UnknownHostException, IOException {
		Socket sk=new Socket("127.0.0.1",6868);
		
		Scanner sc=new Scanner(System.in);
		
		BufferedReader read=new BufferedReader(new InputStreamReader(sk.getInputStream()));
		PrintWriter pw=new PrintWriter(sk.getOutputStream());
		
		System.out.println("请输入您的问题:");
		String line=sc.nextLine();
		
		while(!"bye".equals(line)){
			pw.println(line);
			pw.flush();
			
			line=read.readLine();
			if("bye".equals(line)){
				break;
			}
			System.out.println("服务器回答说:"+line);
			System.out.println("请输入您的问题：");
			line=sc.nextLine();
		}
		
		pw.println();
		pw.flush();
		
		read.close();
		pw.close();
		
		sk.close();
	}
}
