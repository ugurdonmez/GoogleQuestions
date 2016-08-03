package pramp.meeting_schedule;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Created by ugurdonmez on 03/08/16.
 */
public class Solution {

    public static void main(String [] args) {

        int [][] timesA = {{40,45}, {60,70}, {80,90},{10,15}};
        int [][] timesB = {{20,25}, {55, 65}, {1,7}, {100, 200}};

        scheduleMeeting(3, timesA, timesB).ifPresent(System.out::println);
    }


    public static Optional<Interval> scheduleMeeting(int duration, int [][] timesA, int [][] timesB) {

        List<Interval> intervalsA = Arrays.stream(timesA)
                .map(a -> new Interval(a[0], a[1]))
                .sorted()
                .collect(Collectors.toList());

        List<Interval> intervalsB = Arrays.stream(timesB)
                .map(a -> new Interval(a[0], a[1]))
                .sorted()
                .collect(Collectors.toList());

        int indexA = 0;
        int indexB = 0;

        while (indexA < intervalsA.size() && indexB < intervalsB.size()) {
            int start = Integer.max(intervalsA.get(indexA).start, intervalsB.get(indexB).start);
            int end = Integer.min(intervalsA.get(indexA).end, intervalsB.get(indexB).end);

            if (start + duration <= end) {
                return Optional.of(new Interval(start, start+duration));
            }

            if (intervalsA.get(indexA).start < intervalsB.get(indexB).start) {
                indexA++;
            } else {
                indexB++;
            }
        }

        return Optional.empty();
    }

}

class Interval implements Comparable<Interval> {

    final int start;
    final int end;

    public Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public int compareTo(Interval o) {
        return Integer.compare(this.start, o.start);
    }

    @Override
    public String toString() {
        return "Interval{" +
                "start=" + start +
                ", end=" + end +
                '}';
    }
}