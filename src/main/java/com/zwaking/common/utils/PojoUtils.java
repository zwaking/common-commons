package com.zwaking.common.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * @author waking
 */
public class PojoUtils {

    private static Logger logger = LogManager.getLogger();

    /**
     * 验证对象属性是否为空
     *
     * @param obj
     * @param filedsnames
     * @return
     */
    public static boolean validataPojoFileds(Object obj, String... filedsnames) {
        try {
            for (String filedname : filedsnames) {
                if (obj.getClass().getMethod("get" + StringUtils.upperCaseFirstLetter(filedname)).invoke(obj) == null) {
                    logger.debug("obj.getClass()中" + filedname + "为空");
                    return false;
                }
            }
        } catch (Exception e) {
            logger.error("验证对象属性是否为空发生异常", e);
            return false;
        }
        return true;
    }
}
