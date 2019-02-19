import java.util.*;
public class MeetingRooms {

    public boolean canAttendMeetings(List<Interval> intervals) {
        if (intervals == null || intervals.size() == 0)
            return true;

        Interval[] myArray = intervals.toArray(new Interval[0]);
        //sort with comparator
//        Arrays.sort(myArray, new Comparator<Interval>() {
//            @Override
//            public int compare(Interval o1, Interval o2) {
//                return o1.start - o2.start;
//            }
//        });

        //sort with lambda expression
        Arrays.sort(myArray, (i1, i2) -> i1.start - i2.start);
        int end = myArray[0].end;
        for(int i = 1; i < myArray.length; i++) {
            if (myArray[i].start < end) {
                return false;
            }
            end = Math.max(end, myArray[i].end);
        }
        return true;

    }


}
