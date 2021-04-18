package com.zwaking.common.utils;

import java.util.List;
import java.util.stream.Collectors;
import org.apdplat.word.segmentation.Segmentation;
import org.apdplat.word.segmentation.SegmentationAlgorithm;
import org.apdplat.word.segmentation.SegmentationFactory;
import org.apdplat.word.segmentation.Word;

/**
 * 分词处理器
 *
 * @author waking
 * @date 2020/11/25 11:25
 */
public class SegmentationUtils {

    private final static String INITIALIZE_WORD = "你好,中国";

    private final static Segmentation segmentation;

    static {
        segmentation = SegmentationFactory.getSegmentation(SegmentationAlgorithm.MaximumMatching);
        segmentation.seg(INITIALIZE_WORD);
    }

    public static List<String> segmentation(String keyword) {
        List<Word> wordList = segmentation.seg(keyword);
        return wordList.stream().map(Word::getText).collect(Collectors.toList());
    }
}
