package Arrays.medium;
/**this algo is very easy to understand
 * 1.it's given that a element will be always in majority...
 * therefore, the total count of that element will be greater than total count of all other elements
 * */
public class MorreVotinAlgo {
    public int majorityElement(int[] nums) {
        int count = 0;
        Integer candidate = null;
        //what we do here is to check whether the element are same are not
        //the output will tell us that the majority element will have atleast 1 count
        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }
            //as we traverse we add if the ele is same or subtract if ele is diff
            count += (num == candidate) ? 1 : -1;
        }

        return candidate;
    }
}
