package com.giraffe.test;

import org.junit.Test;

import com.giraffe.utils.MD5Utils;

public class OtherTest {
	
	/**
	 * 测试MD5Utils的加密功能
	 */
	@Test
	public void testMD5(){
		String str = MD5Utils.encode("");
		System.out.println(str);
	}
}
