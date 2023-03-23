package Greedy.medium;

import java.util.Arrays;
import java.util.LinkedList;

public class QueueReconstruction {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (p1, p2) -> {
            //here we are checking for both equal height case and less than height case
            return p1[0] == p2[0] ? p1[1] - p2[1] : p2[0] - p1[0];
        });
        LinkedList<int[]> list = new LinkedList<>();
        for (int i = 0; i < people.length; i++)
            list.add(people[i][1], people[i]);
//just add them to required index which will be number of people ahead of them
        return list.toArray(people);
    }
}
