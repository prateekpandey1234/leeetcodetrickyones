
import java.lang.reflect.Array;
import java.util.*;

public class Practice {

    public String removeDuplicateLetters(String s) {
        HashMap<Character,Integer> Map = new HashMap<>();
        StringBuilder ans = new StringBuilder();
        int i=0;
        int lexsum=0;
        while(i<s.length()){
            char[] subarr = Arrays.copyOfRange(s.toCharArray(),0,i);
            if(!Map.containsKey(s.charAt(i))){
                Map.put(s.charAt(i),i);
                ans.append(s.charAt(i));
                lexsum = checkorder(subarr,i);
                System.out.println(lexsum);
                System.out.println(subarr);
            }
            else{
                int newlexsum = checkorder(subarr,i);
                if(newlexsum>lexsum){
                    ans.deleteCharAt(Map.get(s.charAt(i)));
                    ans.append(s.charAt(i));
                    lexsum = newlexsum;
                    System.out.println("lex");
                }
            }
            i++;
        }
        return ans.toString();
    }
    public int checkorder(char[] str , int i ){
        int sum = 0;
        for(int j =0;j<str.length-1;j++){
            if(str[j+1]>str[j]){
                sum++;}
            else
            {sum--;};
        }
        return sum;
    }
}
