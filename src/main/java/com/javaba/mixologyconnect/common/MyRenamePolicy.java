package com.javaba.mixologyconnect.common;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.oreilly.servlet.multipart.FileRenamePolicy;

public class MyRenamePolicy implements FileRenamePolicy{

	@Override
	public File rename(File originalFile) {

		long currentTime = System.currentTimeMillis();
	
		SimpleDateFormat ft = new SimpleDateFormat("yyyyMMddHHmmss");

		int ranNum = (int) (Math.random() * 100000);
						
		String str = "_" + String.format("%05d", ranNum);
		String name = originalFile.getName();
		String ext = null;

		int dot = name.lastIndexOf(".");

		if (dot != -1) {
			// dot 포함해서 확장자 추출 (ext)
			ext = name.substring(dot);
		} else {
			// 확장자가 없는 경우
			ext = "";
		}

		String fileName = ft.format(new Date(currentTime)) + str + ext;
		
		File newFile = new File(originalFile.getParent(), fileName);

		return newFile;
	
	
	}

	
	
}
