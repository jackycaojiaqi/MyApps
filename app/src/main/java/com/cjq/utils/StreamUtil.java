/**
 * Copyright (c) www.bugull.com
 */

package com.cjq.utils;

import java.io.Closeable;
import java.io.IOException;

/**
 *
 * @author Frank Wen(xbwen@hotmail.com)
 */
public final class StreamUtil {
    
    /**
     * 安全关闭IO流
     * @param stream 
     */
    public static void safeClose(Closeable stream) {
        if (stream != null) {
            try {
                stream.close();
            } catch (IOException ex) {
                //do nothing
            }
        }
    }

}
