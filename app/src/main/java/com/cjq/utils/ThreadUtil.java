/**
 * Copyright (c) www.bugull.com
 */

package com.cjq.utils;

import android.util.Log;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * 
 * @author Frank Wen(xbwen@hotmail.com)
 */
public final class ThreadUtil {
    
    private final static String TAG = "ThreadUtil";
    
    public static void sleep(long time){
        try {
            Thread.sleep(time);
        } catch (InterruptedException ex) {
            Log.e(TAG, ex.getMessage(), ex);
        }
    }
    
    public static void sleep(long millis, int nanos){
        try {
            Thread.sleep(millis, nanos);
        } catch (InterruptedException ex) {
            Log.e(TAG, ex.getMessage(), ex);
        }
    }
    
    /**
     * 安全关闭线程池
     * @param pool 
     */
    public static void safeClose(ExecutorService pool) {
        if(pool != null){
            pool.shutdown();
            try{
                if (!pool.awaitTermination(5, TimeUnit.SECONDS)) {
                    pool.shutdownNow();
                }
            }catch(InterruptedException ex){
                Log.e(TAG, ex.getMessage(), ex);
            }
            pool = null;
        }
    }

}
