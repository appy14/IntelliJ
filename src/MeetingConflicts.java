import java.util.*;

/**
 * Created by apaswami on 4/21/17.
 */
public class MeetingConflicts {

    public static List<Interval> getAvailable(Interval[] intervals, double start, double end) {
        if (intervals == null || intervals.length == 0) {
            return Collections.emptyList();
        }

        List<Interval> available = new ArrayList<>();
        available.add(new Interval(start, end));

        int i = 0;

        for (Interval interval : intervals) {
            if (interval.start >= available.get(i).start) {
                double tmp = available.get(i).end;

                if (interval.end == available.get(i).start) {
                    available.get(i).start = interval.end;
                } else {
                    available.get(i).end = interval.start;
                    available.add(new Interval(interval.end, tmp));
                    i++;
                }
            } else {
                if (interval.end > available.get(i).start) {
                    available.get(i).start = interval.end;
                }
            }
        }
        return available;
    }

    public static void main(String[] args) {
        Interval[] intervals = new Interval[3];

        intervals[0] = new Interval(7, 10.5);
        intervals[1] = new Interval(12, 13);
        intervals[2] = new Interval(14, 15);

        List<Interval> available = getAvailable(intervals, 8, 17);

        for (Interval a : available) {
            System.out.println(a.start + " " + a.end);
        }
    }
}
