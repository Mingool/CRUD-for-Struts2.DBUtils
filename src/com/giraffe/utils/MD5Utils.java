package com.giraffe.utils;

import java.security.NoSuchAlgorithmException;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

public class MD5Utils {
	
	/**
	 * MD5À„∑®+BASE64±‡¬Î
	 * @param str
	 * @return
	 */
	public static String encode(String str){
		java.security.MessageDigest md = null;
		try {
			md = java.security.MessageDigest.getInstance("md5");
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
			return null;
		}
		byte[] print = md.digest(str.getBytes());
		return new BASE64Encoder().encode(print);
	}
}
