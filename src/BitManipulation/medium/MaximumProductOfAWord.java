package BitManipulation.medium;

public class MaximumProductOfAWord {
    //In this code, the concept of hashing is used to represent each word as a bitmask. The bitmask represents the presence of
    // characters in the word. Each character is mapped to a unique bit position using the ASCII value. For example, 'a' is mapped
    // to bit position 0, 'b' to bit position 1, and so on.

// To hash a word, we iterate over each character in the word and set the corresponding bit in the bitmask using the bitwise OR
// operation (|=). This way, each word is represented by a unique bitmask.

// During the nested loop, we compare the hash of the current word with the hashes of all previously processed words. If there are
// no common set bits in the two bitmasks (i.e., (mask[i] & mask[j]) == 0), it means the two words have no common characters.
// In this case, we calculate the product of the lengths of these two words and update the maximum product (ans) if necessary
    //if we have a word "abc" and use mask[i] |= (ch - 'a'), the resulting bitmask would be 0 | (0 + 1) | (1 + 2) = 3. Here, 'a'
    // is mapped to bit 0, 'b' is mapped to bit 1, and 'c' is mapped to bit 2. However, this approach fails if the characters are
    // not consecutive or distinct, such as in the case of uppercase characters or non-alphabetic characters.

// To ensure a unique bit position for each character, we use the expression 1 << (ch - 'a'). Here, ch - 'a' calculates the
// difference between the character and 'a', which gives us a value that represents the bit position for that character. By
// shifting 1 left by that bit position, we set the corresponding bit in the bitmask. This guarantees a unique representation
// for each character in the word.

// For example, using mask[i] |= 1 << (ch - 'a') for the word "abc" would result in the bitmask
// 0 | (1 << 0) | (1 << 1) | (1 << 2) = 7, which correctly represents the presence of characters
// 'a', 'b', and 'c' using different bit positions.

    // In summary, by using mask[i] |= 1 << (ch - 'a'), we ensure a unique and consistent representation of
    // each character in the word, regardless of the character's value or position in the alphabet.
    public int maxProduct(String[] words) {
        int n = words.length;
        int ans = 0;
        int[] mask = new int[n];

        for (int i = 0; i < n; i++) {
            for (char ch : words[i].toCharArray()) {
                mask[i] |= 1 << (ch - 'a'); // Hashing the word
            }

            for (int j = 0; j < i; j++) {
                if ((mask[i] & mask[j]) == 0) { // Checking if there are no common set bits in the hash of words[i] and words[j]
                    ans = Math.max(ans, words[i].length() * words[j].length());
                }
            }
        }

        return ans;
    }

}
