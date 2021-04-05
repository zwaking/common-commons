package com.zwaking.common.lock;

import java.util.HashMap;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author waking
 * @date 2021/1/27 10:00
 */
public class SegmentLock<T> {
    private final HashMap<Integer, ReentrantLock> lockMap = new HashMap<>();

    /**
     * 默认分段数量
     */
    private Integer segments = 16;

    public SegmentLock() {
        init(null, false);
    }

    public SegmentLock(Integer counts, boolean fair) {
        init(counts, fair);
    }

    private void init(Integer counts, boolean fair) {
        if (counts != null) {
            segments = counts;
        }
        for (int i = 0; i < segments; i++) {
            lockMap.put(i, new ReentrantLock(fair));
        }
    }

    public void lock(T key) {
        ReentrantLock lock = lockMap.get(key.hashCode() % segments);
        lock.lock();
    }

    public void unlock(T key) {
        ReentrantLock lock = lockMap.get(key.hashCode() % segments);
        lock.unlock();
    }
}
