package com.zwaking.common.utils;

import com.zwaking.common.utils.oshi.RuntimeInfo;

/**
 * <p>
 *
 * </p>
 *
 * @author waking
 * @date 2022/10/10
 */
public class RuntimeUtilsTest {

    public static void main(String[] args) {
        RuntimeInfo runtimeInfo = new RuntimeInfo();
        System.out.println(runtimeInfo.getMaxMemory()/1024.0/1024.0/1024.0 + " G");
        System.out.println(runtimeInfo.getFreeMemory()/1024.0/1024.0/1024.0 + " G");
        System.out.println(runtimeInfo.getTotalMemory()/1024.0/1024.0/1024.0 + " G");
        System.out.println(runtimeInfo.getUsableMemory()/1024.0/1024.0/1024.0 + " G");
        System.out.println(runtimeInfo.getRuntime().availableProcessors());

        System.out.println(JvmMemoryUtils.getUsableMemory());
    }
}
