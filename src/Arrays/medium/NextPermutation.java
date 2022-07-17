package Arrays.medium;
/**
 * One of the best array questions
 * Solution::https://www.youtube.com/watch?v=LuLCLgMElus&list=PLgUwDviBIf0rPG3Ictpu74YWBQ1CaBkm2&index=10
 * Strivers Sde sheet*/
public class NextPermutation {
    public void nextPermutation(int[] A) {
        if(A==null && A.length<=1) return;
        int i=A.length-2;
        //used to check for digit which is not in ascending order
        while(i>=0 && A[i]>=A[i+1])i--;
        if(i>=0){
            int j= A.length-1;
            while(A[j]<=A[i])j--;
            //swapping that unordered digit with the one which is just greater than it
            //we can find that one by traversing again from back
            swap(A,i,j);
        }
        //reversing the last subarray to ensure it as an exact next permutation
        reverse(A,i+1,A.length-1);
    }
    public void swap(int[] A,int i , int j){
        int tmp = A[i];
        A[i] = A[j];
        A[j]=tmp;
    }
    public void reverse(int[] A, int i , int j)
    {
        //textbook method to swap array
        while(i<j)swap(A,i++,j--);
    }
}
