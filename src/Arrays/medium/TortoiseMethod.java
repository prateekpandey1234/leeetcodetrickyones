package Arrays.medium;
/**Its and good technique to solve DSA questions*/
public class TortoiseMethod {
    //tortoise method or linked cycle detection method
    //https://takeuforward.org/data-structure/find-the-duplicate-in-an-array-of-n1-integers/

    public static int findDuplicate2(int[] nums) {
        int slow = nums[0];
        int fast = nums[0];
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);

        fast = nums[0];
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }
    public int findDuplicate(int[] nums) {

        int duplicate = -1;
        for (int i = 0; i < nums.length; i++) {
            int cur = Math.abs(nums[i]);
            if (nums[cur] < 0) {
                duplicate = cur;
                break;
            }
            nums[cur] *= -1;
        }

        // Restore numbers
        for (int i = 0; i < nums.length; i++)
            nums[i] = Math.abs(nums[i]);

        return duplicate;
    }
}
