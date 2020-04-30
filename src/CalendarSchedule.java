import java.util.*;

public class CalendarSchedule {
    public List<Interval> getAvailableIntervals(List<Interval> list1, List<Interval> list2, int start, int end) {
        //check corner cases
        if (list1 == null && list2 == null) {
            return null;
        }
        List<Interval> result = new ArrayList<>();
        List<Interval> mergedList = new ArrayList<>();
        mergedList.addAll(list1);
        mergedList.addAll(list2);
        //lambda expression for comparator
        Collections.sort(mergedList, (a, b) -> a.start - b.start);
        int maxEnd = mergedList.get(0).end;
        if (mergedList.get(0).start - start >= 30) {
            if (mergedList.get(0).start <= end) {
                result.add(new Interval(start, mergedList.get(0).start));
            } else {
                result.add(new Interval(start, end));
                return result;
            }
        }
        for (int i = 1; i < mergedList.size(); i++) {
            if (maxEnd >= start && maxEnd <= end) {
                if (mergedList.get(i).start - maxEnd >= 30) {
                    if (mergedList.get(i).start <= end) {
                        result.add(new Interval(maxEnd, mergedList.get(i).start));
                    } else {
                        result.add(new Interval(maxEnd, end));
                        return result;
                    }
                }
            } else if (maxEnd < start){
                if (mergedList.get(i).start - start >= 30) {
                    result.add(new Interval(start, mergedList.get(i).start));
                }

                if (i == mergedList.size() - 1 && mergedList.get(i).end <= end - 30) {
                    result.add(new Interval(mergedList.get(i).end, end));
                }
            }

            maxEnd = Math.max(maxEnd, mergedList.get(i).end);
        }

        return result;
    }

    public static void main(String[] args) {
        // case 1:
        Interval i1 = new Interval(480, 520);
        Interval i2 = new Interval(600, 720);
        List<Interval> l1 = new ArrayList<>();
        List<Interval> l2 = new ArrayList<>();
        l1.add(i1);
        l2.add(i2);
        int start = 540;
        int end = 780;
        List<Interval> res = new ArrayList<>();
        CalendarSchedule cs = new CalendarSchedule();
        res = cs.getAvailableIntervals(l1, l2, start, end);
        System.out.println("Available intervals");
        for(Interval interval : res) {
            System.out.println("startTime: " + interval.start + "  endTime: " + interval.end);
        }


//        Interval i3 = new Interval(540, 580);
//        l1.add(i3);
//        res = cs.getAvailableIntervals(l1, l2, start, end);
//        System.out.println("Available intervals");
//        for(Interval interval : res) {
//            System.out.println("startTime: " + interval.start + "  endTime: " + interval.end);
//        }



    }

}

