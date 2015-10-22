package BitSet;

/**
 * Created by ZXM on 10/21/15.
 * 有一大堆meeting， 有start time和end time，都是integer，
 * 且在一天之内，代表一天内的第几分钟。然后让返回boolean代表这些是否有overlap，
 * 然后楼主就naive了，就写了个comparator sort了，
 * 按start time 排序后一个个检查下一个的start time是否小于上一个的end time。
 * 然后小哥说有没有更好的办法，提示了一下说用一个数组。
 * 然后楼主恍然大悟，就开了个1440 大小的bit的数组写了个O(n)的。
 */

import java.util.BitSet;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**analysis
 * A straightforward answer is to sort the meetings based on the start time
 * then we iterate through the meeting and check if prev.end overlaps with next.start
 * This takes O(nlogn) time where n is the number of meetings
 *
 * Another way is to use bit set to represents minutes.
 * We will need a bit set for meeting start time and one bit set for meeting end time
 * There are total 1440 bits for one day.
 *
 * Iterate through all the meetings, if there are two meetings starts or end at the same time, then overlaps
 * Then iterate through the bit sets and use a counter to track how many meetings was going on at minute i.
 * If count > 0 and there is meeting starts at minute i, they overlaps
 *
 */

class Meeting {
    int start;
    int end;
    public Meeting(int start, int end) {
        this.start = start;
        this.end = end;
    }
}
public class OverlappingMeeting {

    public boolean findOverlappingMeetingsUsingSort(List<Meeting> meetings) {
        if (meetings == null || meetings.size() == 0) return false;
        Collections.sort(meetings, new Comparator<Meeting>() {
            @Override
            public int compare(Meeting a, Meeting b) {
                return a.start - b.start;
            }
        });
        Meeting prev = meetings.get(0);
        for (int i = 1; i < meetings.size(); i++) {
            Meeting next = meetings.get(i);
            if (prev.end > next.start) return true;
            prev = next;
        }

        return false;
    }

    public boolean findOverlappingMeetingsUsingBitSet(List<Meeting> meetings) {
        if (meetings == null || meetings.size() == 0) return false;
        BitSet starts = new BitSet(1440);
        BitSet ends = new BitSet(1440);
        for (Meeting meeting : meetings) {
            if (starts.get(meeting.start)) return true;
            starts.set(meeting.start);
            ends.set(meeting.end);
        }
        int count = 0;
        for (int i = 0; i < 1440; i++) {
            if (ends.get(i)) count -= 1;
            if (count > 0 && starts.get(i)) return true;
            if (starts.get(i)) count++;
        }

        return false;

    }
}
