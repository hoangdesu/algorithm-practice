// Link: https://leetcode.com/problems/concatenation-of-array/

import java.util.Arrays;

public class Solution {
    public int[] getConcatenation(int[] nums) {
        int[] ans = new int[nums.length * 2];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = nums[i % nums.length];
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(Arrays.toString(s.getConcatenation(new int[]{ 1,2,1 })));
    }
}
