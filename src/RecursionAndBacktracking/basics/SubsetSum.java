package RecursionAndBacktracking.basics;
//the intuition here is to do recursion by taking and excluding an element separately and performing sum there
public class SubsetSum {
    static void subsetSums(int[] arr, int l, int r, int sum)
    {
         // Print current subset
        if (l > r) {
            System.out.print(sum + " ");
            return;
        }

        // Subset including arr[l]
        subsetSums(arr, l + 1, r, sum + arr[l]);

        // Subset excluding arr[l]
        subsetSums(arr, l + 1, r, sum);
    }
}
