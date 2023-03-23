package Arrays.hard;

import java.util.Arrays;
import java.util.Comparator;

public class MinimumTimeToCompleteTasks {
    class Solution {
        public int findMinimumTime(int[][] tasks) {
            //the main greedy approach here is that we need to complete tasks before their end time and hence we sort the array using end time
            int ans=0;
            boolean[] time = new boolean[2001];
            Arrays.sort(tasks, Comparator.comparingInt(a->a[1]));//sorting on basis of end time
            for(int i=tasks[0][1]-tasks[0][2]+1;i<=tasks[0][1];i++){
                time[i]=true;//making every sec true as we turn on our computer for our very first task
                ans++;
            }
            //minimum possible time would be for that tasks whose end is earliest
            for(int k=1;k<tasks.length;k++){
                int[] curr=tasks[k];
                for(int i=curr[0];i<=curr[1];i++){
                    if(time[i])curr[2]--;//running our tasks with prev tasks
                }
                for(int i=curr[1];i>=curr[0] && curr[2] >0;i--){//what we are doing here is that for remaning duration we will run our tasks backwards from end point upto the point our duration finishes
                    if(!time[i]){
                        time[i]=true;
                        ans++;
                        curr[2]--;
                    }
                }
            }
            return ans;
        }
    }
}
