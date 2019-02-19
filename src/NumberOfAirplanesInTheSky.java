import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class NumberOfAirplanesInTheSky {
    public static int countOfAirplanes(List<Interval> airplanes) {

        if (airplanes == null || airplanes.isEmpty()) {
            return 0;
        }

        int max = 0;

        //sort by start time, ascending
        Collections.sort(airplanes, (o1, o2) -> o1.start - o2.start);


        //minHeap
        PriorityQueue<Interval> q = new PriorityQueue<>(1, (a, b) -> a.end - b.end);

        for (int i = 0; i < airplanes.size(); i++) {
            Interval curr = airplanes.get(i);
            while (!q.isEmpty() && q.peek().end <= curr.start) {
                q.poll();
            }
            q.add(curr);
            max = Math.max(max, q.size());
        }

        return max;
    }

    public static void main(String[] args) {
        List<Interval> airplanes = new ArrayList<>();

        airplanes.add(new Interval(2, 3));
        airplanes.add(new Interval(5, 8));
        airplanes.add(new Interval(4, 7));
        airplanes.add(new Interval(1, 10));


        int count = countOfAirplanes(airplanes);
        System.out.println(count);

    }
}
