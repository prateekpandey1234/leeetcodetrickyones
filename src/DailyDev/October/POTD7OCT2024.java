package DailyDev.October;

import java.util.Stack;

public class POTD7OCT2024 {
    public int minLength(String s) {
        Stack<Character> stck = new Stack<>();
        int ans=s.length();
        for(char c :s.toCharArray()){
            if(c=='A' || c=='C'){
                stck.push(c);
            }
            else if(c=='B' && !stck.isEmpty() && stck.peek()=='A'){
                ans-=2;
                stck.pop();
            }
            else if(c=='D' && !stck.isEmpty() && stck.peek()=='C'){
                ans-=2;
                stck.pop();
            }
            else stck.clear();
        }
        return ans;
    }
}
