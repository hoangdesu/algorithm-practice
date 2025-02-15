// Link: https://leetcode.com/problems/is-subsequence/description/

public class Solution {
    public boolean isSubsequence(String s, String t) {
        if (s.length() == 0) return true;

        int j = 0;

        for (int i = 0; i < t.length(); i++) {
            if (s.charAt(j) == t.charAt(i)) j++;
            if (j == s.length()) return true;
        }

        return false;
    }
    

    public static void main(String[] args) {
        Solution s = new Solution();
        
        System.out.println(s.isSubsequence("abc", "ahbgdc"));
        System.out.println(s.isSubsequence("axc", "ahbgdc"));
        
    }
}
