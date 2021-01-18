package com.zwaking.common.utils;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class TestJsonUtils {

    @Test
    public void testBean2Json(){
        List<TTT> tttList = new ArrayList<>();
        TTT ttt1 = new TTT();
        TTT ttt2 = new TTT();
        TTT ttt3 = new TTT();
        tttList.add(ttt1);
        tttList.add(ttt2);
        tttList.add(ttt3);
        System.out.println(JsonUtils.bean2Json(tttList));
    }

}
