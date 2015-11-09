/**
 * Copyright (c) www.bugull.com
 */

package com.cjq.utils;

/**
 * 字节操作辅助类。
 * 
 * @author Frank Wen(xbwen@hotmail.com)
 */
public final class ByteUtil {

	/**
	 * 修改字节中某一比特位的值，得到一个新的字节。 最左边是第7位，最右边是第0位。
	 * 
	 * @param b
	 * @param position
	 * @param value
	 * @return
	 */
	public static byte setBit(byte b, int position, boolean value) {
		int op = 1 << position;
		int temp = 0;
		if (value) {
			temp = b | op;
		} else {
			op = ~op;
			temp = b & op;
		}
		return (byte) temp;
	}

	/**
	 * 获取字节中某一比特位的值。 最左边是第7位，最右边是第0位。
	 * 
	 * @param b
	 * @param position
	 * @return
	 */
	public static boolean getBit(byte b, int position) {
		String s = toBinaryString(b);
		char c = s.charAt(7 - position);
		return c == '1';
	}

	/**
	 * 将字节用二进制形式显示。
	 * 
	 * @param b
	 * @return
	 */
	public static String toBinaryString(byte b) {
		String binary = null;
		int i = (int) b;
		String s = Integer.toBinaryString(i);
		if (i >= 0) {
			int len = s.length();
			if (len < 8) {
				int offset = 8 - len;
				for (int j = 0; j < offset; j++) {
					s = "0" + s;
				}
			}
			binary = s;
		} else {
			binary = s.substring(24);
		}
		return binary;
	}

	/**
	 * 将字节用十六进制形式显示。
	 * 
	 * @param b
	 * @return
	 */
	public static String toHexString(byte b) {
		String hex = null;
		int i = (int) b;
		String s = Integer.toHexString(i);
		if (i >= 0) {
			int len = s.length();
			if (len < 2) {
				s = "0" + s;
			}
			hex = s;
		} else {
			hex = s.substring(6);
		}
		return hex.toUpperCase();
	}

	/**
	 * 把二进制形式的字符串解析成字节
	 * 
	 * @param s
	 * @return
	 */
	public static byte parseBinaryString(String s) {
		int i = Integer.parseInt(s, 2);
		return (byte) i;
	}

	/**
	 * 把十六进制形式的字符串解析成字节
	 * 
	 * @param s
	 * @return
	 */
	public static byte parseHexString(String s) {
		int i = Integer.parseInt(s, 16);
		return (byte) i;
	}

	/**
	 * 多个字节（字节数组）的异或
	 * 
	 * @param bytes
	 * @return
	 */
	public static byte xor(byte... bytes) {
		byte result = 0x00;
		for (byte b : bytes) {
			result ^= b;
		}
		return result;
	}

	/**
	 * 字节数组中一部分内容的异或
	 * 
	 * @param bytes
	 *            字节数组
	 * @param begin
	 *            开始字节（包括）
	 * @param end
	 *            结束字节（不包括）
	 * @return
	 */
	public static byte xor(byte[] bytes, int begin, int end) {
		byte result = 0x00;
		for (int i = begin; i < end; i++) {
			result ^= bytes[i];
		}
		return result;
	}

	/**
	 * 多个字节的和校验，忽略进位。
	 * 
	 * @param bytes
	 * @return
	 */
	public static byte sum(byte... bytes) {
		byte result = 0x00;
		for (byte b : bytes) {
			result += b;
		}
		return result;
	}

	/**
	 * 字节数组一部分内容的和校验，忽略进位。
	 * 
	 * @param bytes
	 *            字节数组
	 * @param begin
	 *            开始字节（包括）
	 * @param end
	 *            结束字节（不包括）
	 * @return
	 */
	public static byte sum(byte[] bytes, int begin, int end) {
		byte result = 0x00;
		for (int i = begin; i < end; i++) {
			result += bytes[i];
		}
		return result;
	}

	/**
	 * 把int整数，转换成4字节的数组
	 * 
	 * @param x
	 * @return
	 */
	public static byte[] fromInt(int x) {
		byte[] result = new byte[4];
		result[0] = (byte) ((x >> 24) & 0xFF);
		result[1] = (byte) ((x >> 16) & 0xFF);
		result[2] = (byte) ((x >> 8) & 0xFF);
		result[3] = (byte) (x & 0xFF);
		return result;
	}

	/**
	 * 把字节数组转换成整数。只取最前面的4字节。
	 * 
	 * @param bytes
	 * @return
	 */
	public static int toInt(byte[] bytes) {
		int value = 0;
		for (int i = 0; i < 4; i++) {
			int shift = (4 - 1 - i) * 8;
			value += (bytes[i] & 0xFF) << shift;
		}
		return value;
	}

	public static byte[] fromShort(short x) {
		byte[] result = new byte[2];
		result[0] = (byte) ((x >> 8) & 0xFF);
		result[1] = (byte) (x & 0xFF);
		return result;
	}

	public static short toShort(byte[] bytes) {
		short value = 0;
		for (int i = 0; i < 2; i++) {
			int shift = (2 - 1 - i) * 8;
			value += (bytes[i] & 0xFF) << shift;
		}
		return value;
	}

	/**
	 * 把long型整数，转换成8字节的数组。
	 * 
	 * @param x
	 * @return
	 */
	public static byte[] fromLong(long x) {
		byte[] result = new byte[8];
		result[0] = (byte) ((x >> 56) & 0xFF);
		result[1] = (byte) ((x >> 48) & 0xFF);
		result[2] = (byte) ((x >> 40) & 0xFF);
		result[3] = (byte) ((x >> 32) & 0xFF);
		result[4] = (byte) ((x >> 24) & 0xFF);
		result[5] = (byte) ((x >> 16) & 0xFF);
		result[6] = (byte) ((x >> 8) & 0xFF);
		result[7] = (byte) (x & 0xFF);
		return result;
	}

	/**
	 * 把字节数组转换成long型整数。只取最前面的8字节。
	 * 
	 * @param bytes
	 * @return
	 */
	public static long toLong(byte[] bytes) {
		long value = 0;
		for (int i = 0; i < 8; i++) {
			int shift = (8 - 1 - i) * 8;
			value += ((long) (bytes[i] & 0xFF)) << shift;
		}
		return value;
	}

	/**
	 * 把float型浮点数，转换成4字节的数组。
	 * 
	 * @param x
	 * @return
	 */
	public static byte[] fromFloat(float x) {
		int i = Float.floatToIntBits(x);
		return fromInt(i);
	}

	/**
	 * 把字节数组转换成float类型。只取最前面的4字节。
	 * 
	 * @param bytes
	 * @return
	 */
	public static float toFloat(byte[] bytes) {
		int i = toInt(bytes);
		return Float.intBitsToFloat(i);
	}

	/**
	 * 把double型数据，转换成8字节的数组。
	 * 
	 * @param x
	 * @return
	 */
	public static byte[] fromDouble(double x) {
		long l = Double.doubleToRawLongBits(x);
		return fromLong(l);
	}

	/**
	 * 把字节数组转换成double类型。只取最前面的8字节。
	 * 
	 * @param bytes
	 * @return
	 */
	public static double toDouble(byte[] bytes) {
		long l = toLong(bytes);
		return Double.longBitsToDouble(l);
	}

	public static String toHexString(byte[] bytes) {
		if (isEmpty(bytes)) {
			return null;
		}
		StringBuilder sb = new StringBuilder();
		for (byte b : bytes) {
			sb.append(toHexString(b));
		}
		return sb.toString();
	}

	public static boolean isEmpty(byte[] bytes) {
		return bytes == null || bytes.length == 0;
	}

	public static byte[] parseHexStringToArray(String s) {
		if (StringUtil.isEmpty(s)) {
			return null;
		}
		int len = s.length();
		if (len % 2 != 0) {
			return null;
		}
		int size = len / 2;
		byte[] data = new byte[size];
		for (int i = 0; i < size; i++) {
			String sub = s.substring(i * 2, i * 2 + 2);
			data[i] = parseHexString(sub);
		}
		return data;
	}

	public static byte int2OneByte(int num) {
		return (byte) (num & 0x000000ff);
	}

	public static int oneByte2Int(byte byteNum) {
		// 针对正数的int
		return byteNum > 0 ? byteNum : (128 + (128 + byteNum));
	}

}
