package com.zwaking.common.utils;

import java.util.Map;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import lombok.extern.log4j.Log4j2;

/**
 * @author: waking
 * @date: 2020/11/25 11:25
 */
@Log4j2
public class JsonUtils {

    private static ObjectMapper objectMapper = new ObjectMapper();

    public static String bean2JsonStr(Object obj) {
        try {
            return objectMapper.writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            log.error("bean2JsonStr Convert Has Error", e);
        }
        return null;
    }

    public static Map bean2Map(Object obj) {
        try {
            if (String.class.isAssignableFrom(obj.getClass())) {
                return objectMapper.readValue(obj.toString(), Map.class);
            }
            return objectMapper.convertValue(obj, Map.class);
        } catch (Exception e) {
            log.debug("bean2Map Convert Has Error", e);
        }
        return null;
    }

    public static JsonNode bean2JsonNode(Object obj) {
        try {
            if (String.class.isAssignableFrom(obj.getClass())) {
                return objectMapper.readTree(obj.toString());
            }
            return objectMapper.readTree(objectMapper.writeValueAsBytes(obj));
        } catch (Exception e) {
            log.debug("bean2JsonNode Convert Has Error", e);
        }
        return null;
    }

    /**
     * <p>
     * 将在下个下版本移除
     * </p>
     * 
     * @see com.zwaking.common.utils.JsonUtils#bean2JsonNode(Object)
     * @return
     */
    @Deprecated
    public static ObjectNode bean2Json(Object obj) {
        return objectMapper.convertValue(obj, ObjectNode.class);
    }

    public static <T> T jsonStr2Bean(String jsonStr, Class<T> clazz) {
        T t = null;
        try {
            t = objectMapper.readValue(jsonStr, clazz);
        } catch (JsonProcessingException e) {
            log.error("jsonStr2Bean Convert Has Error", e);
        }
        return t;
    }
}
