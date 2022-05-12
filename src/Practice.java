

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class Practice {
    private HashMap<Character, char[]> phonemap;
    public void letterCombinations(String digits) {
        int n = digits.length();

        phonemap = new HashMap<>();
        phonemap.put('2', new char[]{'a','b','c'});
        phonemap.put('3', new char[]{'d','e','f'});
        phonemap.put('4', new char[]{'g','h','i'});
        phonemap.put('5', new char[]{'j','k','l'});
        phonemap.put('6', new char[]{'m','n','o'});
        phonemap.put('7', new char[]{'p','q','r','s'});
        phonemap.put('8', new char[]{'t','u','v'});
        phonemap.put('9', new char[]{'w','x','y','z'});

    }
}
