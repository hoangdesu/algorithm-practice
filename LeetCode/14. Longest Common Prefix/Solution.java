class Solution {
    public String longestCommonPrefix1(String[] strs) {
        StringBuilder commonPrefix = new StringBuilder();
        String first = strs[0];

        int i = 0;
        while (i < strs.length) {
            for (int j = 0; j < strs.length; j++) {
                String word = strs[j];
                if (word.charAt(i) != first.charAt(i) || i >= word.length()) {
                    return commonPrefix.toString();
                }
            }
            commonPrefix.append(first.charAt(i));
            i++;
        }
        return commonPrefix.toString();
    }

    public String longestCommonPrefix(String[] strs) {
        // redoing...
    }

    public static void main(String[] args) {
        String[] strs1 = {"flower","flow","flight"};
        String[] strs2 = {"dog","racecar","car"};

        String s1 = longestCommonPrefix(strs1);
        System.out.println(s1);

        System.out.println(longestCommonPrefix(strs2));

        // DIDNT WORK
    }
}