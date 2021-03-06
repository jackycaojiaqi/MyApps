/**
 * Copyright (c) www.bugull.com
 */

package com.cjq.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import android.util.Log;

/**
 *
 * @author Frank Wen(xbwen@hotmail.com)
 */
public final class StringUtil {

	/**
	 * 判断字符串是否为空
	 * 
	 * @param s
	 * @return
	 */
	public static boolean isEmpty(String s) {
		return s == null || s.trim().length() == 0;
	}

	/**
	 * 判断是否为空的JSON字符串
	 * 
	 * @param s
	 * @return
	 */
	public static boolean isEmptyJson(String s) {
		if (isEmpty(s)) {
			return true;
		}
		s = s.replaceAll(" ", "");
		return s.equals("[]") || s.equals("{}");
	}

	/**
	 * 判断是否为空的XML字符串
	 * 
	 * @param s
	 * @return
	 */
	public static boolean isEmptyXml(String s) {
		return isEmpty(s);
	}

	/**
	 * 从网址或路径中获取文件名
	 * 
	 * @param uri
	 * @return
	 */
	public static String getFilename(String uri) {
		if (isEmpty(uri)) {
			return null;
		}
		int slash = uri.lastIndexOf("/");
		return uri.substring(slash + 1);
	}

	/**
	 * 获取文件后缀名，不包括.号
	 * 
	 * @param filename
	 * @return
	 */
	public static String getExtention(String filename) {
		if (isEmpty(filename)) {
			return null;
		}
		String ext = null;
		int index = filename.lastIndexOf(".");
		if (index > 0) {
			ext = filename.substring(index + 1);
		}
		return ext;
	}

	/**
	 * 根据文件扩展名，获取文件类型。支持常用的、能够在Android上打开的文件类型。
	 * 
	 * @param ext
	 * @return
	 */
	public static String getContentType(String ext) {
		if (ext == null) {
			return null;
		}
		ext = ext.toLowerCase();
		String type = null;
		if (ext.equals("jpg") || ext.equals("jpeg")) {
			type = "image/jpeg";
		} else if (ext.equals("png")) {
			type = "image/png";
		} else if (ext.equals("mp4")) {
			type = "video/mp4";
		} else if (ext.equals("mpg") || ext.equals("mpeg")) {
			type = "video/mpeg";
		} else if (ext.equals("ppt") || ext.equals("pptx")) {
			type = "application/vnd.ms-powerpoint";
		} else if (ext.equals("doc") || ext.equals("docx")) {
			type = "application/msword";
		} else if (ext.equals("xls") || ext.equals("xlsx")) {
			type = "application/vnd.ms-excel";
		} else if (ext.equals("pdf")) {
			type = "application/pdf";
		} else if (ext.equals("epub")) {
			type = "application/epub+zip";
		} else if (ext.equals("txt")) {
			type = "text/plain";
		} else {
			type = "application/octet-stream";
		}
		return type;
	}

	/**
	 * 判断字符串是否全为英文字母
	 * 
	 * @param s
	 * @return
	 */
	public static boolean isAllLetter(String s) {
		String regex = "[a-zA-Z]+";
		Pattern p = Pattern.compile(regex);
		return p.matcher(s).matches();
	}

	/**
	 * 判断字符串是否全为数字
	 * 
	 * @param s
	 * @return
	 */
	public static boolean isAllDigit(String s) {
		String regex = "\\d+";
		Pattern p = Pattern.compile(regex);
		return p.matcher(s).matches();
	}

	/**
	 * 判断是否为有效的Email
	 * 
	 * @param email
	 * @return
	 */
	public static boolean isValidEmail(String email) {
		if (isEmpty(email)) {
			return false;
		}
		// \\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*
		Pattern p = Pattern
				.compile("[A-Z0-9a-z._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,4}"); // 复杂匹配
		Matcher m = p.matcher(email);
		return m.matches();
	}

	/**
	 * 判断是否为有效的Username
	 * 
	 * @param username
	 * @return
	 */
	public static boolean isValidUsername(String username) {
		if (isEmpty(username)) {
			return false;
		}
		Pattern p = Pattern.compile("[0-9a-zA-Z_]{6,40}"); // 6~40位字母或数字
		Matcher m = p.matcher(username);
		return m.matches();
	}

	/**
	 * 判断是否为有效的Password
	 * 
	 * @param password
	 * @return
	 */
	public static boolean isValidPassword(String password) {
		if (isEmpty(password)) {
			return false;
		}
		Pattern p = Pattern.compile("[0-9a-zA-Z]{6,12}"); // 6~12位字母或数字
		Matcher m = p.matcher(password);
		return m.matches();
	}

	/**
	 * 用MD5对字符串进行加密
	 * 
	 * @param s
	 * @return
	 */
	public static String encodeMD5(String s) {
		if (isEmpty(s)) {
			return null;
		}
		MessageDigest md = null;
		try {
			md = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException ex) {
			Log.e("StringUtil", "Can't encode to md5 string", ex);
			return null;
		}
		char[] hexDigits = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
				'A', 'B', 'C', 'D', 'E', 'F' };
		md.update(s.getBytes());
		byte[] datas = md.digest();
		int len = datas.length;
		char str[] = new char[len * 2];
		int k = 0;
		for (int i = 0; i < len; i++) {
			byte byte0 = datas[i];
			str[k++] = hexDigits[byte0 >>> 4 & 0xf];
			str[k++] = hexDigits[byte0 & 0xf];
		}
		return new String(str);
	}

	/**
	 * 把形如AABBCCDDEEFF的字符串，转换成AA:BB:CC:DD:EE:FF这样的MAC地址字符串
	 * 
	 * @param s
	 * @return
	 */
	public static String toMac(String s) {
		if (isEmpty(s)) {
			return null;
		}
		int len = s.length();
		if (len % 2 != 0) {
			return null;
		}
		int size = len / 2;
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < size; i++) {
			String sub = s.substring(i * 2, i * 2 + 2);
			sb.append(sub).append(":");
		}
		return sb.substring(0, sb.length() - 1);
	}

}
