/**
 * Created by apaswami on 4/21/17.
 */
public class Interval implements Comparable<Interval>{
    double start;
    double end;

    public Interval(double start, double end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public int compareTo(Interval o) {
        if (this == o) {
            return 0;
        }
        if (this.start == o.start && this.end == o.end) {
            return 0;
        }
        if (this.start < o.start || (this.start == o.start && this.end > o.end)) {
            return -1;
        }
        return 1;
    }

    @Override
    public String toString() {
        return start + " " + end;
    }
}
