// Link: https://leetcode.com/problems/find-the-highest-altitude/description/?envType=study-plan-v2&envId=leetcode-75

class Solution {
    public int largestAltitude(int[] gain) {
        int highestAltitude = 0;
        int altitude = 0;
        for (int n : gain) {
            altitude += n;
            if (altitude > highestAltitude)
                highestAltitude = altitude;
        }
        return highestAltitude;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.largestAltitude(new int[] { -5, 1, 5, 0, -7 }));
        System.out.println(s.largestAltitude(new int[] { -4, -3, -2, -1, 4, 3, 2 }));
    }
}
