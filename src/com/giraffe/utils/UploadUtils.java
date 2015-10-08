package com.giraffe.utils;

import java.io.File;

public class UploadUtils {
	
	/**
	 * 利用哈希码值计算文件存储路径并返回
	 * @param filename
	 */
	public static String mkDirs(String storePath,String filename){
		int hashcode = filename.hashCode();
		int dir1 = hashcode & 0xf;
		int dir2 = (hashcode & 0xf0) >> 4;
		StringBuilder sb = new StringBuilder(storePath);
		sb.append("\\");
		sb.append(dir1);
		sb.append("\\");
		sb.append(dir2);
		File file = new File(sb.toString());
		if (!file.exists())
			file.mkdirs();
		return sb.toString();
	}
}
