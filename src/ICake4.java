import java.util.*;

/**
 * Created by apaswami on 6/17/17.
 */
public class ICake4 {

    public static List<Meeting> mergeMeetings(List<Meeting> meetings) {
        if (meetings == null || meetings.size() == 0) {
            throw new IllegalArgumentException();
        }
        if (meetings.size() == 1) {
            return meetings;
        }
        List<Meeting> merged = new ArrayList<>();

        Collections.sort(meetings, new Comparator<Meeting>() {
            @Override
            public int compare(Meeting o1, Meeting o2) {
                if (o1.getStart() < o2.getStart()) {
                    return -1;
                } else if (o1.getStart() > o2.getStart()) {
                    return 1;
                } else {
                    if (o1.getEnd() < o2.getEnd()) {
                        return -1;
                    } else if (o1.getEnd() > o2.getEnd()) {
                        return 1;
                    }
                    return 0;
                }
            }
        });

        Iterator<Meeting> iterator = meetings.iterator();
        Meeting next = iterator.next();

        merged.add(new Meeting(next.getStart(), next.getEnd()));
        Meeting prev = merged.get(0);

        while (iterator.hasNext()) {
            next = iterator.next();

            if (next.getStart() > prev.getEnd()) {
                merged.add(new Meeting(next.getStart(), next.getEnd()));
                prev = merged.get(merged.size() - 1);
            } else if (next.getStart() > prev.getStart()) {
                prev.setEnd(next.getEnd());
            }
        }

        return merged;
    }

    public static void main(String[] args) {
        List<Meeting> meetings = new ArrayList<>();
        meetings.add(new Meeting(0, 1));
        meetings.add(new Meeting(3, 5));
        meetings.add(new Meeting(4, 8));
        meetings.add(new Meeting(10, 12));
        meetings.add(new Meeting(9, 10));

        for (Meeting m : mergeMeetings(meetings)) {
            System.out.println(m.getStart() + " " + m.getEnd());
        }

    }
}
