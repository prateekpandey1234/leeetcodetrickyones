package StacksAndQueues.medium;

import java.util.Arrays;
import java.util.PriorityQueue;
/**these two are very good solutions to the questions*/
public class KweakestRow {
    public int[] kWeakestRows(int[][] mat, int k) {
        int rows = mat.length;
        int cols = mat[0].length;

        int[] score = new int[rows];
        int j;
        for (int i = 0; i < rows; i++) {
            j = 0;
            for (; j < cols; j++) {
                if (mat[i][j] == 0) {
                    break;
                }
            }
            /*
             * we can create a score to match the sort condition from description
             * score = soldiersCount * rows + currentRowIndex
             * so we can get soldiersCount by score / rows, and get rowIndex by score % rows
             */
            score[i] = j * rows + i;
        }

        Arrays.sort(score);
        for (int i = 0; i < score.length; i++) {
            // get rowIndex
            score[i] = score[i] % rows;
        }

        return Arrays.copyOfRange(score, 0, k);
    }
    public int[] kWeakestRows2(int[][] mat, int k) {
        //here we sort our PQ (a, b) -> a[0] != b[0] ? a[0] - b[0] : a[1] - b[1] condition....
        //use ternary operators to understand...
        PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> a[0] != b[0] ? a[0] - b[0] : a[1] - b[1]);
        int pos=0;
        //here we do binary search for pos where pos==0;
        for (int[] row : mat){
            int lo = 0, hi = row.length;
            while(lo < hi){
                int mid = (lo + hi) / 2;
                if (row[mid] != 0) lo = mid + 1;
                else hi = mid;
            }
            q.add(new int[]{lo, pos++});
        }

        int[] output = new int[k];
        for(int i = 0; i < k; i++)  output[i] = q.remove()[1];
        return output;
    }
}
