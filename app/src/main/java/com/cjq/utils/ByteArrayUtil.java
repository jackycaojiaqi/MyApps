/**
 * Copyright (c) www.bugull.com
 */

package com.cjq.utils;

import java.util.Arrays;
import java.util.Locale;

/**
 * 字节数组辅助类。
 * 
 * @author Frank Wen(xbwen@hotmail.com)
 */
public final class ByteArrayUtil {

    /**
     * 生成一个字节数组，用0x00填充。
     * 
     * @param size
     * @return
     */
    public static byte[] array00(int size) {
        return array(size, (byte) 0x00);
    }

    /**
     * 生成一个字节数组，用0xFF填充。
     * 
     * @param size
     * @return
     */
    public static byte[] arrayFF(int size) {
        return array(size, (byte) 0xFF);
    }

    /**
     * 生成一个字节数组，用指定的元素填充。
     * 
     * @param size
     * @param value
     * @return
     */
    public static byte[] array(int size, byte value) {
        byte[] bytes = new byte[size];
        for (int i = 0; i < size; i++) {
            bytes[i] = value;
        }
        return bytes;
    }

    /**
     * 反转一个字节数组。
     * 
     * @param bytes
     * @return
     */
    public static byte[] reverse(byte[] bytes) {
        int size = bytes.length;
        byte[] result = new byte[size];
        for (int i = 0; i < size; i++) {
            result[size - 1 - i] = bytes[i];
        }
        return result;
    }

    /**
     * 与字符串的trim()方法类似。去掉数组左右两边的0x00元素，返回一个子数组。 如果数组元素全为0x00，则返回null
     * 
     * @param bytes
     * @return
     */
    public static byte[] trim00(byte[] bytes) {
        return trim(bytes, (byte) 0x00);
    }

    /**
     * 与字符串的trim()方法类似。去掉数组左右两边的0xFF元素，返回一个子数组。 如果数组元素全为0xFF，则返回null
     * 
     * @param bytes
     * @return
     */
    public static byte[] trimFF(byte[] bytes) {
        return trim(bytes, (byte) 0xFF);
    }

    /**
     * 与字符串的trim()方法类似。去掉数组左右两边特定的元素，返回一个子数组。
     * 
     * @param bytes
     * @param element
     * @return
     */
    public static byte[] trim(byte[] bytes, byte element) {
        int size = bytes.length;
        int begin = -1;
        int end = -1;
        for (int i = 0; i < size; i++) {
            if (bytes[i] != element) {
                begin = i;
                break;
            }
        }
        for (int j = size - 1; j > -1; j--) {
            if (bytes[j] != element) {
                end = j;
                break;
            }
        }
        if (begin == -1 || end == -1) {
            return null;
        }
        return Arrays.copyOfRange(bytes, begin, end + 1);
    }

    /**
     * 2个字节数组相连接，拼凑成一个新的字节数组。
     * 
     * @param arr1
     * @param arr2
     * @return
     */
    public static byte[] concat(byte[] arr1, byte[] arr2) {
        int size1 = arr1.length;
        int size2 = arr2.length;
        byte[] result = new byte[size1 + size2];
        System.arraycopy(arr1, 0, result, 0, size1);
        System.arraycopy(arr2, 0, result, size1, size2);
        return result;
    }

    /**
     * 字节数组转换成十六进制的字符串
     * 
     * @param data 数据源
     * @param separator 字节间的分隔字符串
     * @return
     */
    public static String byteArrayToHexString(byte[] data, String separator) {
        return byteArrayToHexString(data, 0, data.length, separator);
    }

    /**
     * 字节数组转换成十六进制的字符串
     * 
     * @param data 数据源
     * @param offset 起始偏移量
     * @param length 字节数
     * @param separator 字节间的分隔字符串
     * @return
     */
    public static String byteArrayToHexString(byte[] data, int offset, int length, String separator) {
        if (length == 0) {
            return "";
        }
        int offsetLength = offset + length;
        if (data == null || data.length < offsetLength) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = offset; i < offsetLength; i++) {
            byte b = data[i];
            String hex = Integer.toHexString(b & 0xFF).toUpperCase(Locale.ENGLISH);
            sb.append(hex.length() < 2 ? "0" + hex : hex);
            sb.append(separator);
        }
        sb.setLength(sb.length() - separator.length());
        return sb.toString();
    }
}
