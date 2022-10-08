package com.zwaking.common.utils;

import cn.hutool.system.oshi.OshiUtil;
import java.math.BigDecimal;
import java.math.RoundingMode;
import oshi.SystemInfo;
import oshi.hardware.CentralProcessor;
import oshi.hardware.GlobalMemory;
import oshi.hardware.HardwareAbstractionLayer;

public class OSHIUtils {

    public static void main(String[] args) {
        SystemInfo systemInfo = new SystemInfo();
        HardwareAbstractionLayer hardware = systemInfo.getHardware();
        CentralProcessor processor = hardware.getProcessor();
        System.out.println(processor);
//        System.out.println(JsonUtils.bean2JsonStr(processor.getProcessorCpuLoad(5000)));
        GlobalMemory globalMemory = hardware.getMemory();
        System.out.println(globalMemory);
        Long available = globalMemory.getAvailable();
        Long total = globalMemory.getTotal();
        System.out.println("总内存(bytes): " + total);
        System.out.println("当前可用的内存(bytes): " + available);
        System.out.println("剩余可用内存(bytes): " + new BigDecimal((double)(available)/(double)total*100).setScale(2, RoundingMode.HALF_UP) + " %");
        System.out.println("当前CPU负载: " + OshiUtil.getCpuInfo().getUsed() + " %");
    }
}
