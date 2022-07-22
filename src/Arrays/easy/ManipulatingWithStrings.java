package Arrays.easy;
/**Now we loop through the entire String of magazine where char c stores the char at the index of magazine..

 You might think why I types c-'a'
 It is because in ascii if you subtract any char with 'a' , it gives you index of that alphabet.*/
public class ManipulatingWithStrings {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] alphabets_counter = new int[26];
        //26 is for number of alphabets

        for (char c : magazine.toCharArray())
            alphabets_counter[c-'a']++;

        for (char c : ransomNote.toCharArray()){
            //to check the same  count
            if (alphabets_counter[c-'a'] == 0) return false;
            alphabets_counter[c-'a']--;
        }
        return true;
    }
}
