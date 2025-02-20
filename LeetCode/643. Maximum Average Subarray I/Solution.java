// Link: https://leetcode.com/problems/maximum-average-subarray-i/description/?envType=study-plan-v2&envId=leetcode-75

public class Solution {
    // NOTE: this solution works, but we will waste time recalculating the new sum to find the new average
    // instead we can add the new value at tail and subtract the old value at head => eliminate another loop
    public double findMaxAverage1(int[] nums, int k) {
        int head = 0;
        int tail = head + k - 1;

        int sum = 0;
        for (int i = head; i <= tail; i++) {
            sum += nums[i];
        }

        double maxAvg = (double) sum / k;

        while (tail < nums.length) {
            sum = 0;
            for (int i = head; i <= tail; i++) {
                sum += nums[i];
            }
            double currentAvg = (double) sum / k;
            if (currentAvg > maxAvg) maxAvg = currentAvg;

            // System.out.printf("head=%d, tail=%d, sum=%d, currentAvg=%.2f, maxAvg=%.2f \n", head, tail, sum, currentAvg, maxAvg);

            head++;
            tail++;
        }

        return maxAvg;
    }

    public double findMaxAverage(int[] nums, int k) {
        int head = 0;
        int tail = head + k - 1;

        int sum = 0;
        for (int i = head; i <= tail; i++) {
            sum += nums[i];
        }

        double maxAvg = (double) sum / k;

        while (tail < nums.length - 1) {
            // NOTE: ok so this is the difference!
            // Subtracting the head value and adding the tail value while keeping the rest of the array the same
            // => Avoid another loop => Optimized
            // A typical solution using the Sliding Window algorithm

            sum -= nums[head];
            head++;
            tail++;
            sum += nums[tail];

            double currentAvg = (double) sum / k;
            if (currentAvg > maxAvg) maxAvg = currentAvg;

            System.out.printf("head=%d, tail=%d, sum=%d, currentAvg=%.2f, maxAvg=%.2f \n", head, tail, sum, currentAvg, maxAvg);
        }

        return maxAvg;
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.findMaxAverage(new int[]{1,12,-5,-6,50,3}, 4));
        System.out.println(s.findMaxAverage(new int[]{5}, 1));
        System.out.println(s.findMaxAverage(new int[]{8860,-853,6534,4477,-4589,8646,-6155,-5577,-1656,-5779,-2619,-8604,-1358,-8009,4983,7063,3104,-1560,4080,2763,5616,-2375,2848,1394,-7173,-5225,-8244,-809,8025,-4072,-4391,-9579,1407,6700,2421,-6685,5481,-1732,-8892,-6645,3077,3287,-4149,8701,-4393,-9070,-1777,2237,-3253,-506,-4931,-7366,-8132,5406,-6300,-275,-1908,67,3569,1433,-7262,-437,8303,4498,-379,3054,-6285,4203,6908,4433,3077,2288,9733,-8067,3007,9725,9669,1362,-2561,-4225,5442,-9006,-429,160,-9234,-4444,3586,-5711,-9506,-79,-4418,-4348,-5891}, 93));
    }
}
