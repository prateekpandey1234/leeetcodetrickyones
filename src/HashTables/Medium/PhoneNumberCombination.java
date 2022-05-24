package HashTables.Medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
//very good use of recursion
public class PhoneNumberCombination {
    class Solution {

        public void solve(String digits,int index, List<String> answerList, Map<Character, char[]> mappings, char[] answer){

            if(index==digits.length()){
                answerList.add(new String(answer));
                return;
            }
            char[] mapArray = mappings.get(digits.charAt(index));
            for(int i=0;i<mapArray.length;i++){
                answer[index] = mapArray[i];
                solve(digits, index+1, answerList, mappings, answer);
            }
        }


        public List<String> letterCombinations(String digits) {

            List<String> answerList = new ArrayList<>();

            if(digits==null || digits.isEmpty()){
                return answerList;
            }

            Map<Character, char[]> mappings = new HashMap<>();

            mappings.put('2',new char[]{'a','b','c'}); mappings.put('3',new char[]{'d','e','f'});
            mappings.put('4',new char[]{'g','h','i'}); mappings.put('5',new char[]{'j','k','l'});
            mappings.put('6',new char[]{'m','n','o'}); mappings.put('7',new char[]{'p','q','r','s'});
            mappings.put('8',new char[]{'t','u','v'}); mappings.put('9',new char[]{'w','x','y','z'});

            char[] answer = new char[digits.length()];

            solve(digits, 0, answerList, mappings, answer);

            return answerList;
        }
    }
}
