package RecursionAndBacktracking.medium;

import java.util.ArrayList;
import java.util.List;
//Create an empty list rs to store the generated Gray Code sequence.
//
//        Add the initial value 0 to the rs list. This is the starting point of the Gray Code sequence.
//
//        Start a loop from i = 0 to n - 1 to generate the Gray Code sequence for each bit.
//
//        Within the loop, get the current size of the rs list. This size represents the number of elements in the
//        Gray Code sequence up to the current bit.
//
//        Iterate backward through the rs list, starting from the last element (index size - 1) and moving towards
//        the first element (index 0).
//
//        For each element in the current iteration, compute a new number by performing a bitwise OR operation (|)
//        between the element and 1 left-shifted by i positions (1 << i). This operation flips the ith bit of the
//        element.
//
//        Add the newly computed number to the rs list. This represents the next number in the Gray Code sequence.
//
//        Repeat steps 5-7 until all elements in the current iteration have been processed.
//
//        After the loop completes, the rs list will contain the complete Gray Code sequence.
public class GrayCode {
    public List<Integer> grayCode(int n) {
        List<Integer> rs=new ArrayList<Integer>();
        rs.add(0);
        for(int i=0;i<n;i++){
            int size=rs.size();
            for(int k=size-1;k>=0;k--)
                rs.add(rs.get(k) | 1<<i);//put a "1" in the "head" of the old number. (e.g. make "101" to be 1101 (101 | 1000 == 1101))
        }
        return rs;
    }
}
