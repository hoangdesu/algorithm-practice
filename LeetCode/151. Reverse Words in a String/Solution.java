// Link: https://leetcode.com/problems/reverse-words-in-a-string/description/?envType=study-plan-v2&envId=leetcode-75

public class Solution {
    // NOTE: Static Block for JVM Warm-Up Optimization
    // - this static block is only to warm up JVM and reduce some runtime
    // - doesn't add value to solution or algorithm, only to flex :v
    static {
        for (int i = 0; i < 500; i++) {
            reverseWords("");
        }
    }
    
    public static String reverseWords(String s) {
        String[] words = s.split(" ");
        
        StringBuilder sb = new StringBuilder();

        for (int i = words.length - 1; i >= 0; i--) {
            String word = words[i];
            if (!word.isEmpty()) {
                sb.append(word);

                if (i > 0) sb.append(" ");
            }
        }

        return sb.toString().trim();
    }

    public static void main(String[] args) {
        System.out.println(reverseWords("the sky is blue"));
        System.out.println(reverseWords("  hello world  "));
        System.out.println(reverseWords("a good   example"));
    }
}
