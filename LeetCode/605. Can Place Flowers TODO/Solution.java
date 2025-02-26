// Link: 

public class Solution {
    // TODO!!!!
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int availables = 0;

        // TODO: REDO This shit
        if (n > flowerbed.length - 1) return false;

        if (flowerbed.length > 1) {
            if (flowerbed[0] == 0 && flowerbed[1] == 0) availables++;
            if (flowerbed[flowerbed.length - 2] == 0 && flowerbed[flowerbed.length - 1] == 0) availables++;
        } else {
            if (flowerbed[0] == 0) availables++;
        }

        for (int i = 1; i < flowerbed.length - 1; i++) {
            int current = flowerbed[i];
            int left = flowerbed[i-1];
            int right = flowerbed[i+1];
            if (current == 0 && left == 0 && right == 0) {
                availables++;
                i++;
            }
        }
        
        return availables >= n;
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.canPlaceFlowers(new int[] { 1, 0, 0, 0, 1 }, 1));
        System.out.println(s.canPlaceFlowers(new int[] { 1, 0, 0, 0, 1 }, 2));
        System.out.println(s.canPlaceFlowers(new int[] {1,0,0,0,0,1}, 2));
        System.out.println(s.canPlaceFlowers(new int[] {0,0,1,0,1}, 2));
    }
}
