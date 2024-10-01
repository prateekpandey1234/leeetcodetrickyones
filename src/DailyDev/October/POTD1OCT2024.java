package DailyDev.October;

import java.util.HashMap;

public class POTD1OCT2024 {
    class Solution {
        // i tried the first solution but my issue was that i didn't consider negative numbers , so
        // i was implrmrting a sum way , whether we should go with the count way
        // 2nd solution is first approach suing hashmap for keeping count and matching
        // first is much optimised which stores all count of  the remainders in a array
        public boolean canArrange(int[] arr, int k) {
            int[] frequency = new int[k];
            for(int num : arr){
                num %= k;
                if(num < 0) num += k;
                frequency[num]++;
            }
            if(frequency[0]%2 != 0) return false;

            for(int i = 1; i <= k/2; i++)
                if(frequency[i] != frequency[k-i]) return false;

            return true;
        }
        //
        public boolean canArrange1(int[] arr, int k) {
            HashMap <Integer, Integer> mp= new HashMap<>();
            int x=0;
            for(int i=0; i<arr.length; i++){
                x=arr[i]%k;
                if(x<0) x+=k;
                if(!mp.containsKey(x)) mp.put(x, 1);
                else mp.put(x,mp.get(x)+1);
            }
            for(int e: mp.keySet()){
                x=k-e;
                if(e==0){
                    if(mp.get(e)%2!=0) return false;
                }
                else{
                    if(!mp.containsKey(x)) return false;
                    else{
                        int p= mp.get(x);
                        int q= mp.get(e);
                        if(p!=q) return false;
                    }
                }
            }
            return true;
        }
    }
}
