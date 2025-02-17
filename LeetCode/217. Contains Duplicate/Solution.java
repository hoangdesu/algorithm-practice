// Link: https://leetcode.com/problems/contains-duplicate/submissions/1546102390/?envType=problem-list-v2&envId=hash-table

import java.util.HashSet;

public class Solution {
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> seen = new HashSet<>();
        for (int n : nums) {
            if (!seen.contains(n))
                seen.add(n);
            else
                return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Solution s = new Solution();

    }
}
