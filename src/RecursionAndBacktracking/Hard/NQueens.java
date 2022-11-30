package RecursionAndBacktracking.Hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NQueens {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<List<String>>();
        //will require bool row and col to check we are able to add queens futher in the matrix
        helper(result, new ArrayList<String>(), 0, new boolean[n], new boolean[2*n], new boolean[2*n], n);
        return result;
    }

    private void helper(List<List<String>> result, List<String> board, int row, boolean[] cols, boolean[] d1, boolean[] d2, int n){
        if (row == n) {
            result.add(new ArrayList<String>(board));
        }
        for (int col=0; col<n; col++){
            int id1 = col - row + n;
            int id2 = col + row;
            //here we checking whether we can add in this coloumn or not
            if (!cols[col] && !d1[id1] && !d2[id2]){
                char[] r = new char[n];
                Arrays.fill(r, '.');
                r[col] = 'Q';
                board.add(new String(r));
                cols[col] = true;
                d1[id1] = true;
                d2[id2] = true;
                helper(result, board, row+1, cols, d1, d2, n);
                board.remove(board.size()-1);
                //here we are doing backtracking as we are going to previous state
                cols[col] = false;
                d1[id1] = false;
                d2[id2] = false;
            }
        }
    }
}
