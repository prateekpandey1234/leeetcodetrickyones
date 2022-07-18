package Arrays.medium;
/**This approach is very best for search in a sorted 2D array*/
public class SearchIn2DArray {
    public boolean searchMatrix(int[][] matrix, int target) {
        int lo = 0;
        if(matrix.length == 0) return false;
        int n = matrix.length;
        int m = matrix[0].length;
        int hi = (n * m) - 1;
        //please make sure to remember the way we are accessing array elements in 2D array is important
        //it will spare some time in searching through array again
        //I am taking about this one brah ,[matrix[mid/m][mid % m]]
        while(lo <= hi) {
            int mid = (lo + (hi - lo) / 2);
            if(matrix[mid/m][mid % m] == target) {
                return true;
            }
            if(matrix[mid/m][mid % m] < target) {
                lo = mid + 1;
            }
            else {
                hi = mid - 1;
            }
        }
        return false;
    }
}
