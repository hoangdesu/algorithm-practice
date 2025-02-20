// Link: https://leetcode.com/problems/unique-number-of-occurrences/description/?envType=study-plan-v2&envId=leetcode-75

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int n : arr) {
            if (map.get(n) == null) map.put(n, 1);
            else map.put(n, map.get(n) + 1);
        }

        System.out.println("map size: " + map.size());

        // Instead of building another hashmap, I'm trying to compare the sizes after converting map values to set
        // Set automatically removes the duplicated values
        Set<Integer> seen = new HashSet<>(map.values());
        
        // remove the sout on leetcode to improve time complexity
        System.out.println("set size:" + seen.size());

        return map.size() == seen.size();
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.uniqueOccurrences(new int[] { 1, 2, 2, 1, 3 }));
        System.out.println(s.uniqueOccurrences(new int[] { 1, 2, 2, 1, 3, 1 }));
    }
}
