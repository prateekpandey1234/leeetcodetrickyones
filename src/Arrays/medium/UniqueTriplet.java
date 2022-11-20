package Arrays.medium;

import java.util.HashMap;
import java.util.Map;

public class UniqueTriplet {
    //Lets say we have 4 kinds of numbers in m, denote them as a, b, c, d, and their frequency m[a], m[b], m[c], m[d]
    //What we want to find is
    //m[a] * m[b] * m[c]
    //m[a] * m[b] * m[d]
    //m[a] * m[c] * m[d]
    //m[b] * m[c] * m[d]
    //Actually, there are nC3 kinds of combinations we have to consider.
    //If you look closer, the above combinations can be reduce as
    //
    //       left             cnt           right
    //(0)                   * m[a] * (m[b] + m[c] + m[d])
    //(m[a])                * m[b] * (m[c] + m[d])
    //(m[a] + m[b])         * m[c] * (m[d])
    //(m[a] + m[b] + m[c])  * m[d] * (0)
    public int unequalTriplets(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i:nums){
            if(map.containsKey(i)){
                map.put(i,map.get(i)+1);
            }else{
                map.put(i,1);
            }
        }
        int res=0,left =0,right = nums.length;
        //here we are doing the approach as we above mentioned
        for(Map.Entry<Integer,Integer> entr :map.entrySet()){
            right-= entr.getValue();
            res+= right*entr.getValue()*left;
            left+=entr.getValue();
        }
        return res;
    }
}
