package Arrays.easy;

import java.util.ArrayList;
import java.util.List;

public class PascalTriangle {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer> > al = new ArrayList<List<Integer> > (numRows);
        ArrayList<Integer> prev= new ArrayList  <> ();
        for(int i=0; i< numRows; i++){
            ArrayList<Integer> sm = new ArrayList<Integer> ();
            sm.add(1);
            if(i!=0){
                for(int ii=0; ii<prev.size()-1; ii++)
                {
                    int p= prev.get(ii)+ prev.get(ii+1);
                    sm.add(p);
                }
                sm.add(1);
            }
            prev = sm;
            al.add(sm);
        }
        return al;
    }
}
