// Link: https://leetcode.com/problems/container-with-most-water/description/?envType=study-plan-v2&envId=leetcode-75

public class Solution {
    // BRUTEFORCE: O(n^2) -> will get Time Limit Exceeded error on Leetcode
    public int maxAreaBruteForce(int[] height) {
        int largestArea = 0;
        for (int i = 0; i < height.length - 1; i++) {
            for (int j = i+1; j < height.length; j++) {
                int width = j - i;
                int leftHeight = height[i];
                int rightHeight = height[j];
                int smallerHeight = leftHeight <= rightHeight ? leftHeight : rightHeight;
                int area = width * smallerHeight;
                if (area > largestArea) largestArea = area;
            }
        }
        return largestArea;
    }


    // Greedy algorithm -> O(n)
    public int maxArea(int[] height) {
        // setting 2 pointers at 2 ends to maximize the width
        int left = 0;
        int right = height.length - 1;

        int largestArea = 0;
        while (left < right) {
            int width = right - left;
            int leftHeight = height[left];
            int rightHeight = height[right];
            int lowerHeight = Math.min(leftHeight, rightHeight);
            int area = width * lowerHeight;
            largestArea = Math.max(area, largestArea);

            // System.out.printf("leftHeight=%d, rightHeight=%d, width=%d, area=%d, largestArea=%d\n", leftHeight, rightHeight, width, area, largestArea);

            if (leftHeight <= rightHeight) {
                left++;
            } else {
                right--;
            }
        }

        return largestArea;
    }
    

    public static void main(String[] args) {
        Solution s = new Solution();

        int[] arr1 = new int[] { 1, 8, 6, 2, 5, 4, 8, 3, 7 };

        long startTime = System.nanoTime();
        System.out.println(s.maxAreaBruteForce(arr1));
        long endTime = System.nanoTime();
        long t1 = endTime - startTime;
        System.out.println("That took " + t1 + " milliseconds");

        long startTime2 = System.nanoTime();
        System.out.println(s.maxArea(arr1));
        long endTime2 = System.nanoTime();
        long t2 = endTime2 - startTime2;
        System.out.println("That took " + t2 + " milliseconds");

        float eff = ((float) t1 / (float) t2);
        System.out.println("optmized solution is " + eff + " times faster than bruteforce");
    }
}
