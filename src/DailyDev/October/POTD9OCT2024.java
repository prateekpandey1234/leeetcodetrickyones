package DailyDev.October;

public class POTD9OCT2024 {
    class Solution {
        public int minAddToMakeValid(String s) {
            int ans=0;
            int ex=0;
            for(char c:s.toCharArray()){
                if(ans==0 && c==')')ex++;
                else if(c=='(')ans++;
                else  ans--;
            }
            return Math.abs(ans)+ex;
        }
    }
}
