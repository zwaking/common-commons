package com.zwaking.common.utils;

import com.zwaking.common.utils.oshi.RuntimeInfo;
import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * <p>
 *
 * </p>
 *
 * @author waking
 * @date 2022/10/10
 */
public class JvmMemoryUtils {

    public static BigDecimal getUsableMemory() {
        RuntimeInfo runtimeInfo = new RuntimeInfo();

        long maxMemory = runtimeInfo.getMaxMemory();
        long usableMemory = runtimeInfo.getUsableMemory();

        return new BigDecimal((double)(usableMemory) / (double)maxMemory * 100).setScale(2, RoundingMode.HALF_UP);
    }
}
