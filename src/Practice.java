
import java.lang.reflect.Array;
import java.util.*;

public class Practice {

    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        subseq(ans,s.toCharArray(),new ArrayList<>(),0,s.length());
        return ans;
    }
    public void subseq(List<List<String>> res,char[] s , List<String> ls , int l,int r){
        if(l>r){
            if(pallindome(ls,0,ls.size()-1)){
                res.add(new ArrayList<>(ls));
            }
            return;
        }
        ls.add(String.valueOf(s[l]));
        subseq(res,s,ls,l+1,r);
        ls.remove(ls.size()-1);
        subseq(res,s,ls,l+1,r);
    }
    public boolean pallindome(List<String> s,int l,int r){
        if(l>r){
            return true;
        }
        if(s.get(l)!=s.get(r)){return false;}
        return pallindome(s,l+1,r-1);
    }
}
