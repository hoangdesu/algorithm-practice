class Solution {
    // first attempt: close call, but didnt check for index within a str length
    // public String longestCommonPrefix1(String[] strs) {
    //     StringBuilder commonPrefix = new StringBuilder();
    //     String first = strs[0];

    //     int i = 0;
    //     while (i < strs.length) {
    //         for (int j = 0; j < strs.length; j++) {
    //             String word = strs[j];
    //             if (word.charAt(i) != first.charAt(i) || i >= word.length()) {
    //                 return commonPrefix.toString();
    //             }
    //         }
    //         commonPrefix.append(first.charAt(i));
    //         i++;
    //     }

    //     return commonPrefix.toString();
    // }

    public static String longestCommonPrefix(String[] strs) {

        // handle edge cases
        if (strs == null || strs.length == 0) return "";

        StringBuilder output = new StringBuilder();

        int commonIndex = 0;

        // use the first str as the base 
        while (commonIndex < strs[0].length()) {
            char charToCompare = strs[0].charAt(commonIndex);

            for (String word : strs) {
                // char index must be within a str's length
                if (commonIndex < word.length()) {
                    if (word.charAt(commonIndex) != charToCompare) return output.toString();
                } else {
                    return output.toString();
                }
            }

            output.append(charToCompare);
            commonIndex++;
        }

        return output.toString();
    }

    public static void main(String[] args) {
        String[] strs1 = {"flower","flow","flight"};
        String[] strs2 = {"dog","racecar","car"};

        String s1 = longestCommonPrefix(strs1);
        System.out.println(s1);

        System.out.println(longestCommonPrefix(strs2));
    }
}