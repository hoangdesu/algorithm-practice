// Link: https://leetcode.com/problems/merge-strings-alternately/description/

public class Solution {
    public String mergeAlternately1(String word1, String word2) { 
        StringBuilder s = new StringBuilder();
        int i = 0;
        while (true) {
            if (i < word1.length()) s.append(word1.charAt(i));
            if (i < word2.length()) s.append(word2.charAt(i));
            i++;
            if (i > word1.length() && i > word2.length()) break;
        }
        return s.toString();
    }

    public String mergeAlternately(String word1, String word2) { 
        StringBuilder s = new StringBuilder();
        int maxLen = word1.length() > word2.length() ? word1.length() : word2.length();

        for (int i = 0; i < maxLen; i++) {
            if (i < word1.length()) s.append(word1.charAt(i));
            if (i < word2.length()) s.append(word2.charAt(i));
        }

        return s.toString();
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.mergeAlternately("abc", "pqr"));
        System.out.println(s.mergeAlternately("abcd", "pq"));
        
    }
}
