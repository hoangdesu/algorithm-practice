import java.util.HashMap;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> seen = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int acc = target - nums[i];
            if (seen.containsKey(acc)) {
                return new int[]{i, seen.get(acc)};
            } else {
                seen.put(nums[i], i);
            }
        }
        return new int[]{};
    }
}