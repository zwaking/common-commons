package com.zwaking.common.utils;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

public class TestJsonUtils {

    @Test
    public void testBean2Json() {
        List<TTT> tttList = new ArrayList<>();
        TTT ttt1 = new TTT();
        ttt1.setName("ttt1");
        TTT ttt2 = new TTT();
        TTT ttt3 = new TTT();
        tttList.add(ttt1);
        tttList.add(ttt2);
        tttList.add(ttt3);
        System.out.println(JsonUtils.bean2Json(ttt1).get("name"));
    }

    @Test
    public void testBean2Map() {
        TTT ttt = new TTT();
        ttt.setName("ttt1");
        ttt.setAge(1L);
        ttt.setSex("1");
        System.out.println(JsonUtils.bean2Map(ttt));
        String jsonStr = JsonUtils.bean2JsonStr(ttt);
        System.out.println(JsonUtils.bean2Map(jsonStr));
    }

    @Test
    public void testBean2JsonNode() {
         List<TTT> tttList = new ArrayList<>();
         TTT ttt1 = new TTT();
         ttt1.setName("ttt1");
         ttt1.setAge(1L);
         ttt1.setSex("1");
         TTT ttt2 = new TTT();
         ttt2.setName("ttt2");
         ttt2.setAge(2L);
         ttt2.setSex("2");
         TTT ttt3 = new TTT();
         ttt3.setName("ttt3");
         ttt3.setAge(3L);
         ttt3.setSex("3");
         tttList.add(ttt1);
         tttList.add(ttt2);
         tttList.add(ttt3);
         System.out.println(JsonUtils.bean2JsonNode(tttList));

        TTT ttt = new TTT();
        ttt.setName("ttt1");
        ttt.setAge(1L);
        ttt.setSex("1");
        String jsonStr = JsonUtils.bean2JsonStr(ttt);
        System.out.println(JsonUtils.bean2JsonNode(jsonStr).get("name"));

        System.out.println(JsonUtils.bean2JsonNode(1).asText());
    }

}
