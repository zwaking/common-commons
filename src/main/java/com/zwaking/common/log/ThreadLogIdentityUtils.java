package com.zwaking.common.log;

import com.zwaking.common.contextholder.ContextHolder;
import com.zwaking.common.utils.DateTimeUtils;
import com.zwaking.common.utils.StringUtils;

/**
 * 线程唯一Id工具类
 * <p>
 * Title: ThreadLogIdentityUtils
 * </p>
 * <p>
 * Description:
 * </p>
 * <p>
 * Date: 2019-10-15 18:42:52
 * </p>
 *
 * @author waking
 */
public class ThreadLogIdentityUtils {

    /**
     * 创建一个唯一ID
     *
     * @return
     */
    public static String create() {
        String threadLogIdentity;
        try {
            threadLogIdentity = DateTimeUtils.getSequence("tlid");
        } catch (Exception e) {
            threadLogIdentity = "tlid" + StringUtils.createRandomStr(25);
        }

        return threadLogIdentity;
    }

    /**
     * 重置当前线程唯一ID
     */
    public static void reset() {
        ContextHolder.setTHREAD_LOCAL_TLID(create());
    }
}
