package Queue;

/**
 * Created by ZXM on 10/23/15.
 * user想要request车的arrival time。如果1s内多余5条request，就自动忽略，不然就执行，
 *
 */

import java.util.LinkedList;
import java.util.Queue;

/**analysis
 * How to design 5 request in 1 second
 * 86400 seconds
 * 1, 2, 3, 4, 5
 * 4, 6,
 * count total request in 1s
 * count
 *
 * another way of defining 5 seconds
 * define 5 request
 * a. 1/5 = 0.2/s
 *
 * follow up:
 * what if we want to count request the 1s from current time
 * 0.5-1.5
 *
 *0 0    1   1   0   1   1   0   0   1   1   1   1   1   1   1
 *0 .1   .2  .3. .4  .5  .6  .7  .8  .9  1   1.1 1.2 1.3 1.4 1.5
 *
 *There are 3 different ways of designing it
 * we assume the request time is the current system time
 *
 */
public class RateLimiter {
    //below properties are for time gap
    private final double timeGap = 0.2;
    private long lastRequestTime;
    //below properties are for time bucket
    private long lastTime; //in second
    private int count;

    //below properties is for task queue
    private Queue<Long> requestQueue = new LinkedList<>();
    private final int capacity = 5;

    public boolean rateLimiterWithGap(long requestTime) {
        if (requestTime - lastRequestTime >= timeGap) return true;
        return false;
    }


    public boolean rateLimiterWithTimeBucket(long requestTime) {
        long currTime = requestTime / 1000;
        if (requestTime != lastTime) {
            count = 0;
            lastTime = currTime;
        }
        if (count > 5) return false;
        count++;
        return true;

    }

    public boolean rateLimiterWithQueue(long requestTime) {
        while (! requestQueue.isEmpty()) {
            if (requestQueue.peek() + 1000 < requestTime) {
                requestQueue.poll();
            }
        }
        if (requestQueue.size() >= capacity) return false;
        requestQueue.offer(requestTime);
        return true;
    }



}
