package Arrays;

import java.util.ArrayList;

/**
 * Created by Gavin on 4/9/2015.
 */
public class Intervals {
    class Interval {
        int from;
        int to;

        public Interval(int from, int to)
        {
            this.from = from;
            this.to = to;
        }
    }

    ArrayList<Interval> list; //keep the list in ascending order according to interval.from

    public Intervals()
    {
        list = new ArrayList<Interval>();
    }

    /**
     * Use binary search to find the index for insertion.
     * Time complexity O(n)
     *
     * @param from
     * @param to
     */
    void addInterval(int from, int to)
    {

        int s = 0;
        int e = list.size() - 1;
        while (s < e) {
            int m = (s + e) / 2;
            if (list.get(m).from > from) e = m;
            else s = m + 1;
        }
        int index = 0;
        if (!list.isEmpty()) index = list.get(s).from > from ? s : s + 1;
        list.add(index, new Interval(from, to));

    }

    /**
     * Iterate through list from left to right, if two intervals overlaps, update previous interval's range;
     * otherwise, accumulate previous interval's covered length.
     * Time complexity O(n)
     *
     * @return length suggesting the covered length of the intervals in the list
     */
    int getTotalCoveredLength()
    {
        if (list.size() == 0) return 0;
        Interval prev = new Interval(list.get(0).from, list.get(0).to);
        int length = 0;
        for (int i = 1; i < list.size(); i++) {
            Interval curr = list.get(i);
            if (prev.to >= curr.from) prev.to = Math.max(prev.to, curr.to);
            else {
                length += prev.to - prev.from;
                prev = new Interval(curr.from, curr.to);
            }
        }
        length += prev.to - prev.from;
        return length;

    }
}
