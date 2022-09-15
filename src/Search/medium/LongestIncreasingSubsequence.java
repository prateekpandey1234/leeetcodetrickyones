package Search.medium;
//Consider an example - [1,7,8,4,5,6,-1,9]:
//
//Let's pick first element - 1 and form the subseqeunce sub1=[1].
//7 is greater than previous element so extend the sequence by picking it.   sub1=[1,7].
//Similarly, we pick 8 as well since it's greater than 7.   sub1=[1,7,8]
//Now we cant extend it further. We can't simply discard previous sequence and start with 4 nor can we discard 7,8 and place 4 instead of them because we don't know if future increasing subsequence will be of more length or not. So we keep both previous subsequence as well as try picking 4 by forming a new subsequence. It's better to form new subsequence and place 4 after 1 to maximize new sequence length. So we have sub1=[1,7,8] and sub2=[1,4]
//Can we add 5 in any of the sequence? Yes we can add it to sub2. If it wasn't possible we would have tried the same approach as in 4th step and created another subsequence list.   sub1=[1,7,8], sub2=[1,4,5]
//Similarly, add 6 to only possible list - cur2.   sub1=[1,7,8], sub2=[1,4,5,6]
//Now, -1 cant extend any of the existing subsequence. So we need to form another sequence. Notice we cant copy and use any elements from existing subsequences before -1 either, since -1 is lowest. sub1=[1,7,8], sub2=[1,4,5,6], sub3=[-1]
//Now, 9 can be used to extend all of the list. At last, we get   sub1=[1,7,8,9], sub2=[1,4,5,6,9], sub3=[-1,9]
//We finally pick the maximum length of all lists formed till now. This approach works and gets us the correct LIS but it seems like just another inefficient approach because it's costly to maintain multiple lists and search through all of them when including a new element or making a new list. Is there a way to speed up this process? Yes. We can just maintain a single list and mark multiple lists inside it. Again, an example will better explain this.
//
//Consider the same example as above - [1,7,8,4,5,6,-1,9]:
//
//Pick first element - 1 and form the subseqeunce sub=[1].
//
//7 is greater than 1 so extend the existing subsequence by picking it.   sub=[1,7].
//
//Similarly, we pick 8 as well since it's greater than 7.   sub=[1,7,8]
//
//Now comes the main part. We can't extend any existing sequence with 4. So we need to create a new subsequence following 4th step previous approach but this time we will create it inside sub itself by replacing smallest element larger than 4 (Similar to 4th step above where we formed a new sequence after picking smaller elements than 4 from existing sequence).
//
//    [1,    4,      8]
//           ^sub2   ^sub1
//
//This replacement technique works because replaced elements dont matter to us
//We only used end elements of existing lists to check if they can be extended otherwise form newer lists
//And since we have replaced a bigger element with smaller one it wont affect the
//step of creating new list after taking some part of existing list (see step 4 in above approach)
//Now, we can't extend with 5 either. We follow the same approach as step 4.
//
//    [1,    4,    5]
//				 ^sub2
//
//Think of it as extending sub2 in 5th step of above appraoch
//Also, we can see sub2 replaced sub1 meaning any subsequence formed with sub2 always
//has better chance of being LIS than sub1.
//We get 6 now and we can extend the sub list by picking it.
//
//    [1,    4,    5,    6]
//				       ^sub2
//Cant extend with -1. So, Replace -
//
//    [-1,    4,    5,   6]
//	  ^sub3		       ^sub2
//
//We have again formed a new list internally by replacing smallest element larger than -1 from exisiting list
//We get 9 which is greater than the end of our list and thus can be used to extend the list
//
//    [-1,    4,    5,    6,    9]
//	  ^sub3		              ^sub2
//
//Finally the length of our maintained list will denote the LIS length = `5`. Do note that it wont give the LIS itself but just correct length of it.
public class LongestIncreasingSubsequence {
    public int lengthOfLIS(int[] nums) {
        int[] tails = new int[nums.length];
        int size = 0;
        for (int x : nums) {
            int i = 0, j = size;
            while (i != j) {
                int m = (i + j) / 2;
                if (tails[m] < x)
                    i = m + 1;
                else
                    j = m;
            }
            tails[i] = x;
            if (i == size) ++size;
        }
        return size;
    }
}
