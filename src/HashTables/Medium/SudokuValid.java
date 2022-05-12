package HashTables.Medium;

public class SudokuValid {
    class Solution {
        public boolean isValidSudoku(char[][] board) {

            for(int r=0; r<board.length; r++) {
                for(int c=0; c<board.length; c++) {
                    if(board[r][c] != '.') {
                        if(!isSafe(board, r, c, board[r][c])) {
                            return false;
                        }
                    }
                }
            }
            return true;
        }

        public boolean isSafe(char[][] board,int row,int col, char num) {
            int cnt = 0;
            //for checking along the row
            for(int i=0; i<board.length; i++) {
                if(board[row][i] == num ) {
                    cnt++;
                    if(cnt > 1)
                        return false;
                }
            }
            cnt = 0;
            //for checking along the coloumn
            for( int i=0; i<board.length; i++) {
                if(board[i][col] == num ) {
                    cnt++;
                    if(cnt > 1)
                        return false;
                }
            }
            cnt = 0;
            //for checking in the sub box
            int sqrt = (int)Math.sqrt(board.length);
            int boxrow = row - row%sqrt;
            int boxcol = col - col%sqrt;
            for(int i=boxrow; i < boxrow+sqrt; i++) {
                for(int j=boxcol; j<boxcol+sqrt; j++) {
                    if(board[i][j] == num ) {
                        cnt++;
                        if(cnt > 1)
                            return false;
                    }
                }
            }
            return true;
        }
    }
}
