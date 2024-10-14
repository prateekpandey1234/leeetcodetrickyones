package DailyDev.October;

import java.util.*;

public class POTD11OCT2024 {
    class Solution {
        /*
        1.Store the arrivalTime of targetFriend, since all the the arrival times are distinct this can be used to identify the targetFriend in sorted array.
        2.Store all the available seats(one for each friend) in minHeap as available seats.
        3.Sort the times array based on arrival time.
        4.Maintain another minHeap to store leavingTime and occupiedSeat.
        5.loop through sorted array
            1) remove all the friends from the heap whose leavingTime is less than or equal to current arraival time and add the occupied seats back to seats heap.
            2) if the current start is equal to targetStart return the min available seat.
            3) else add the current leaving time and min available seat to heap.
        */
        public int smallestChair(int[][] times, int targetFriend) {
            int targetStart = times[targetFriend][0];
            Arrays.sort(times, (a, b) -> a[0] - b[0]); // sort by start time

            PriorityQueue<Integer> seats = new PriorityQueue<>(); // available seat
            for (int i = 0; i < times.length; ++ i) {
                seats.offer(i);
            }

            PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[0] - b[0]); // leavingTime(sorted), occupiedSeat

            for (int i = 0; i < times.length; ++ i) {
                while (!minHeap.isEmpty() && minHeap.peek()[0] <= times[i][0]) { // poll friends whose leavingTime is less than or equal to current arraival time
                    seats.offer(minHeap.poll()[1]); // add the occupied seats back to available heap
                }

                if (times[i][0] == targetStart) return seats.peek();

                minHeap.offer(new int[]{times[i][1], seats.poll()});
            }

            return seats.peek();
        }
    }
}
