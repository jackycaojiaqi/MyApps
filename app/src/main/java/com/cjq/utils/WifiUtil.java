/**
 * Copyright (c) www.bugull.com
 */

package com.cjq.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;

/**
 * 
 * 
 * @author zhengzhi [zheng_zhi@163.com]
 * 
 * @date 2013-3-11 上午10:08:18
 */
public final class WifiUtil {

	public static final int SIGNAL_LEVEL_NO_WIFI = 0; //没有wifi
	public static final int SIGNAL_LEVEL_VERY_WEAK = 1; //非常弱
	public static final int SIGNAL_LEVEL_WEAK = 2; //弱
	public static final int SIGNAL_LEVEL_NORMAL = 3; //一般
	public static final int SIGNAL_LEVEL_STRONG = 4; //强

	/**
	 * 检查是否有Wifi网络
	 * 
	 * 需要添加权限： <uses-permission android:name="android.permission.ACCESS_NETWORK_STATE" />
	 * 
	 * @param context
	 * @return
	 */
	public static boolean isOpen(Context context) {
		ConnectivityManager mConnectivityManager = (ConnectivityManager) context
				.getSystemService(Context.CONNECTIVITY_SERVICE);
		NetworkInfo mNetworkInfo = mConnectivityManager.getActiveNetworkInfo();

		if (mNetworkInfo == null || !mNetworkInfo.isAvailable()) {
			return false;
		} else {
			return true;
		}
	}

	/**
	 * 检查Wifi网络是否连接
	 * 
	 * 需要添加权限：<uses-permission android:name="android.permission.ACCESS_NETWORK_STATE" />
	 * 
	 * @param context
	 * @return
	 */
	public static boolean isConnected(Context context) {
		ConnectivityManager mConnectivityManager = (ConnectivityManager) context
				.getSystemService(Context.CONNECTIVITY_SERVICE);
		NetworkInfo mNetworkInfo = mConnectivityManager.getActiveNetworkInfo();
		
		if (mNetworkInfo == null || !mNetworkInfo.isAvailable()) {
			return false;
		} else {
			if (mNetworkInfo.isConnected()) {
				if (mNetworkInfo.getState() == NetworkInfo.State.CONNECTED) {
					return true;
				}
			}
			return false;
		}
		
	}
}
