import java.util.HashMap;

class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;

        // trying to compare 2 maps
        HashMap<Character, Integer> sCharMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            // if (sCharMap.containsKey(c)) {
            //     int counter = sCharMap.get(c);
            //     sCharMap.put(c, counter+1);
            // } else {
            //     sCharMap.put(c, 1);
            // }

            // same implementable, but eliminated if-else
            int counter = sCharMap.getOrDefault(c, 0);
            sCharMap.put(c, counter+1);
        }

        HashMap<Character, Integer> tCharMap = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {

            // early return for edge case
            if (!sCharMap.containsKey(t.charAt(i))) return false;

            char c = t.charAt(i);
            if (tCharMap.containsKey(c)) {
                int counter = tCharMap.get(c);
                tCharMap.put(c, counter+1);
            } else {
                tCharMap.put(c, 1);
            }
        }

        System.out.println(sCharMap);
        System.out.println(tCharMap);

        return sCharMap.equals(tCharMap);
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.isAnagram("anagram", "nagaram"));
        System.out.println(s.isAnagram("rat", "car"));
    }


    // TODO: other solutions:
    // - https://www.youtube.com/watch?v=xcSngwhGqfM&ab_channel=TiCungBimDSA
}