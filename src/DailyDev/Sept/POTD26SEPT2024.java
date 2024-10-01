package DailyDev.Sept;

import java.util.TreeMap;

public class POTD26SEPT2024 {
    class MyCalendar {
        // binary search i don't know why is not good here because from what i can think is that
        // elements can not be added that properly with it
        TreeMap<Integer, Integer> calendar;

        MyCalendar() {
            calendar = new TreeMap();
        }

        public boolean book(int start, int end) {
            Integer prev = calendar.floorKey(start),
                    next = calendar.ceilingKey(start);
            //floorKey(start) finds the largest key less than or equal to start. This represents the previous booking.
            //ceilingKey(start) finds the smallest key greater than or equal to start. This represents the next booking.
            if ((prev == null || calendar.get(prev) <= start) &&
                    (next == null || end <= next)) {
                calendar.put(start, end);
                return true;
            }
            //finding that window to add that gap in the treemap
            return false;
        }
    }
}
