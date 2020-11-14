package com.yc.net;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class demo2 {
	public static void main(String[] args) {
		FileOutputStream fos=null;
		InputStream is=null;
		
		try {
			URL url=new URL("https://down.360safe.com/cse/360cse_official.exe");
			URLConnection con=url.openConnection();
			
			
			con.connect();    //连接到远程资源
			
			is=con.getInputStream();
			
			fos=new FileOutputStream(new File("E:\\360cse_official.exe"));
			
			int len=0;
			byte[] bt=new byte[1024];
			while( ( len=is.read(bt))>0){
				fos.write(bt,0,len);
			}
			fos.flush();
			System.out.println("下载完成");
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			if(fos!=null){
				try {
					fos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if(is!=null){
				try {
					is.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
