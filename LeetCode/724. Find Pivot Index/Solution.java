// Link: https://leetcode.com/problems/find-pivot-index/description/?envType=study-plan-v2&envId=leetcode-75

public class Solution {
    // NOTE: this solution works, but time complexity is O(n^2)
    // -> TODO: optimize it to O(n)
    public int pivotIndex(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            // sum all the numbers from the pivot index to the left side
            int leftSum = 0;
            for (int j = 0; j < i; j++) {
                leftSum += nums[j];
            }

            // same thing for the right side
            int rightSum = 0;
            for (int j = i+1; j < nums.length; j++) {
                rightSum += nums[j];
            }

            // System.out.printf("i=%d, leftSum=%d, rightSum=%d\n", i, leftSum, rightSum);

            if (leftSum == rightSum) return i;
        }

        return -1;
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.pivotIndex(new int[]{1,7,3,6,5,6}));
        System.out.println(s.pivotIndex(new int[]{1,2,3}));
        System.out.println(s.pivotIndex(new int[]{2,1,-1}));
        System.out.println(s.pivotIndex(new int[]{-1,-1,0,1,1,0}));
    }
}
