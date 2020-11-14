package com.yc.net;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class demo1 {
	public static void main(String[] args) throws UnknownHostException {
		InetAddress iaddr=null;
		
		System.out.println(InetAddress.getLocalHost());
		System.out.println(InetAddress.getByName("www.baidu.com"));
		System.out.println(InetAddress.getByName("LAPTOP-HMTR2RKT"));
	}
}
