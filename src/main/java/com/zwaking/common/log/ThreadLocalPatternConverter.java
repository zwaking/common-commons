package com.zwaking.common.log;

import com.zwaking.common.contextholder.ContextHolder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.LogEvent;
import org.apache.logging.log4j.core.config.plugins.Plugin;
import org.apache.logging.log4j.core.pattern.ConverterKeys;
import org.apache.logging.log4j.core.pattern.LogEventPatternConverter;
import org.apache.logging.log4j.core.pattern.PatternConverter;

/**
 * @Title ThreadLocalPatternConverter
 * @Description ThreadLocalPatternConverter
 * @Data 2019/06/23 18:39
 * @Author waking
 */
@Plugin(name = "ThreadLocalPatternConverter", category = PatternConverter.CATEGORY)
@ConverterKeys({"tlid"})
public class ThreadLocalPatternConverter extends LogEventPatternConverter {

    private static final Logger log = LogManager.getLogger(ThreadLocalPatternConverter.class);

    private static final ThreadLocalPatternConverter INSTANCE = new ThreadLocalPatternConverter();

    private ThreadLocalPatternConverter() {
        super("tlid", "tlid");
    }

    public static ThreadLocalPatternConverter newInstance(final String[] options) {
        return INSTANCE;
    }

    @Override
    public void format(LogEvent event, StringBuilder toAppendTo) {
        String threadLogIdentity = ContextHolder.getTHREAD_LOCAL_TLID();
        if (threadLogIdentity == null) {
            ContextHolder.setTHREAD_LOCAL_TLID(ThreadLogIdentityUtils.create());
        }

        toAppendTo.append(ContextHolder.getTHREAD_LOCAL_TLID());
    }
}
