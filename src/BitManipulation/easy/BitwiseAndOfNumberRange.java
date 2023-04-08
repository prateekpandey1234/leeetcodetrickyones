package BitManipulation.easy;

public class BitwiseAndOfNumberRange {
    class Solution {
        public int rangeBitwiseAnd(int left, int right) {
            int res = right;
            //we are doing n & n-1 because we will get the same result even though we used for loop and do iteration one by one
            while(right > left) {
                res = right & (right-1);
                right = res;
            }
            return res;
        }
    }
}
