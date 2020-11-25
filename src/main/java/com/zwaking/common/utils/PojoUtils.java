package com.zwaking.common.utils;

import lombok.extern.log4j.Log4j2;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * @author waking
 * @date 2020/11/25 11:25
 */
@Log4j2
public class PojoUtils {

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
                    log.debug("obj.getClass()中" + filedname + "为空");
                    return false;
                }
            }
        } catch (Exception e) {
            log.error("验证对象属性是否为空发生异常", e);
            return false;
        }
        return true;
    }
}
