package com.giraffe.test;

import org.junit.Test;

import com.giraffe.utils.MD5Utils;

public class OtherTest {
	
	/**
	 * ����MD5Utils�ļ��ܹ���
	 */
	@Test
	public void testMD5(){
		String str = MD5Utils.encode("");
		System.out.println(str);
	}
}
