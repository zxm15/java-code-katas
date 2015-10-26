package Map.TreeMap;

/**
 * Created by ZXM on 10/26/15.
 * <p>
 * 自己设计一个data structure，支持以下两个函数：
 * void set(String event, long timestamp);
 * int getCount(Granularity, String event, long startTime, long endTime);
 * 就是说我们首先记录很多个事件发生的时间，存在某种Data structure里面，
 * 然后通过getCount这个function我们可以计算出在某段时间间隔内[startTime, endTime]，
 * 某个事件发生了多少次。同时这个函数还支持多种Granularity，包括Week, day, hour.
 *
 */

import java.util.HashMap;
import java.util.TreeMap;
import java.util.concurrent.TimeUnit;

/**
 * When it comes to range serach, you could think of using segement tree
 * However, in this quesiton, the range is not fixed. therefore the segment tree is out.
 * BST, B tree and treemap are alternatives
 */
public class EventOccurencesRangeSearch {
    private HashMap<String, TreeMap<Long, Integer>> eventMap = new HashMap<>();
    public void set(String event, long timeStamp) {
        if (! eventMap.containsKey(event)) {
            eventMap.put(event, new TreeMap<>());
        }
        TreeMap<Long, Integer> timeMap = eventMap.get(event);
        if (! timeMap.containsKey(timeStamp)) {
            timeMap.put(timeStamp, 1);
        } else {
            timeMap.put(timeStamp, timeMap.get(timeStamp) + 1);
        }
    }

    public int getCount(TimeUnit timeUnit, String event, long startTime, long endTime) {
        if (! eventMap.containsKey(event)) return 0;
        startTime = convertTime(timeUnit, startTime);
        endTime = convertTime(timeUnit, endTime);
        TreeMap<Long, Integer> timeMap = eventMap.get(event);
        TreeMap<Long, Integer> subTimeMap = (TreeMap) timeMap.subMap(timeMap.ceilingKey(startTime), true, timeMap.floorKey(endTime), true);
        int count = 0;
        if (subTimeMap.isEmpty()) return 0;
        for (Long timeStamp : subTimeMap.keySet()) {
            count += subTimeMap.get(timeStamp);
        }

        return count;

    }

    private long convertTime(TimeUnit timeUnit, long time) {
        switch(timeUnit) {
            case DAYS:  return timeUnit.DAYS.toMillis(time);
            case HOURS: return timeUnit.HOURS.toMillis(time);
            case MINUTES: return timeUnit.MINUTES.toMillis(time);
            case SECONDS: return timeUnit.SECONDS.toMillis(time);
            default: return time;
        }
    }
}
