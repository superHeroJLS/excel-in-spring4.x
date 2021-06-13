package com.smart.resource;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.PathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.WritableResource;
import org.springframework.core.io.support.EncodedResource;
import org.springframework.util.FileCopyUtils;

import java.io.*;


public class FileSourceExample {

	public static final String FILE_PATH = "D:/masterspring/wangpan/spring4.x-chapter4/src/main/resources/conf/file1.txt";
	
	public static void main(String[] args) {
		try {
			String filePath = FILE_PATH;
			WritableResource pathRes = new PathResource(filePath);
			Resource classPathRes = new ClassPathResource("/conf/file1.txt");

			OutputStream stream1 = pathRes.getOutputStream();
			stream1.write("欢迎光临\n小春论坛".getBytes());
			stream1.close();

            InputStream pathResIns = pathRes.getInputStream();
			EncodedResource eRes = new EncodedResource(classPathRes, "UTF-8");
			Reader classPathReader = eRes.getReader();

			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			int i;
			while((i=pathResIns.read())!=-1){
				baos.write(i);
			}
			System.out.println("pathRes: " + baos.toString());

			System.out.println("classPathRes: " + FileCopyUtils.copyToString(classPathReader));

			//访问文件的数据和其他信息
            System.out.println("res1:"+pathRes.getFilename());
            System.out.println("res2:"+classPathRes.getFilename());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
