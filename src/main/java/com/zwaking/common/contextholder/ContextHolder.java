package com.zwaking.common.contextholder;

import com.alibaba.ttl.TransmittableThreadLocal;

public class ContextHolder {
  
  /**
   * 线程唯一编号
   */
  private static final TransmittableThreadLocal<String> THREAD_LOCAL_TLID = new TransmittableThreadLocal<>();
  
  public static void setTHREAD_LOCAL_TLID(String tlid) {
    THREAD_LOCAL_TLID.set(tlid);
  }
  
  public static String getTHREAD_LOCAL_TLID() {
    return THREAD_LOCAL_TLID.get();
  }
  
}
