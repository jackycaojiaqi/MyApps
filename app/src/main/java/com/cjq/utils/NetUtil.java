/**
 * Copyright (c) www.bugull.com
 */

package com.cjq.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import java.util.HashMap;
import java.util.Map;


/**
 *
 * @author Frank Wen(xbwen@hotmail.com)
 */
public final class NetUtil {

	private static final String TAG = "NetUtil";

	private static String mMacAddress;

	public static Map<Integer, String> currentNet = new HashMap<Integer, String>();
	public static final String WIFI = "WIFI";
	public static final String MOBILE = "MOBILE";



	/**
	 * 判断是否有网络
	 *
	 * @param context
	 * @return
	 */
	public static boolean isNetworkConnected(Context context) {
		ConnectivityManager cm = (ConnectivityManager) context
				.getSystemService(Context.CONNECTIVITY_SERVICE);
		NetworkInfo info = cm.getActiveNetworkInfo();
		if (info != null) {
			return info.isAvailable();
		} else {
			return false;
		}
	}


}
