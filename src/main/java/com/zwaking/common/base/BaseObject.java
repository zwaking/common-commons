package com.zwaking.common.base;

import com.zwaking.common.utils.JsonUtils;
import lombok.extern.log4j.Log4j2;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

/**
 * @author waking
 * @date 2020/11/25 11:25
 * @title 所有自定义类型的基础类
 * @description 该类可以提供对象信息输出/系统日志输出等公用功能
 */
@Log4j2
public class BaseObject implements Serializable {

    @Override
    public String toString() {
        return JsonUtils.bean2JsonStr(this);
    }

}
