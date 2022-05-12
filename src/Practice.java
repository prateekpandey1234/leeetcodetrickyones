

import java.util.HashMap;


public class Practice {
    private HashMap<Integer,Character>  sud;
    private HashMap<Integer,Character>  sud2;
    public boolean isValidSudoku(char[][] board) {
        int i=0 , j=0;
        while(i<=8){
            sud = new HashMap<>();

            while(j<=8){
                //Row
                char val = board[i][j];
                if(val!='.' && !sud.containsValue(val)){
                    sud.put(Integer.parseInt(String.valueOf(val)),val);
                }
                else if(sud.containsValue(val)){
                    return false;
                }
                //col
                int k =0;
                sud2 = new HashMap<>();
                while(k<=8){
                    char val2 = board[k][j];
                    if(val2!='.' && !sud2.containsValue(val2)){
                        sud2.put(Integer.parseInt(String.valueOf(val2 )),val2);
                    }
                    else if(sud2.containsValue(val2)){
                        return false;
                    }
                    System.out.println(sud2);
                    k++;
                }
                j++;

            }
            System.out.println(sud);
            i++;
        }
        return true;
    }
}
