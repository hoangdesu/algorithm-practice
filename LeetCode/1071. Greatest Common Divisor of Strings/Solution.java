// Link: https://leetcode.com/problems/greatest-common-divisor-of-strings/?envType=study-plan-v2&envId=leetcode-75

public class Solution {
    // WRONG APPROACH
    public String gcdOfStrings1(String str1, String str2) {
        StringBuilder res = new StringBuilder();

        for (int i = 0; i < str2.length(); i++) {
            if (str2.charAt(i) != str1.charAt(i)) return res.toString();

            res.append(str2.charAt(i));
        }

        while (res.length() % 2 == 0) {
            String firstHalf = res.substring(0, res.length() / 2);
            String secondHalf = res.substring(res.length() / 2);
            if (firstHalf.equals(secondHalf)) res = new StringBuilder(firstHalf);
            else break;
        }

        return res.toString();
    } 


    // ATTEMPT 2: still doesnt work
    public String gcdOfStrings2(String str1, String str2) {
        // StringBuilder res = new StringBuilder();

        // while (str2.length() % 2 == 0) {
        //     String firstHalf = str2.substring(0, str2.length() / 2);
        //     String secondHalf = str2.substring(str2.length() / 2);
        //     if (firstHalf.equals(secondHalf)) {
        //         res = new StringBuilder(firstHalf);
        //         System.out.println(res.toString());
        //     } else {
        //         break;
        //     }
        // }

        // return res.toString();

        int gcd = 0;
        for (int i = 1; i <= Math.min(str1.length(), str2.length()); i++) {
            if (str1.length() % i == 0 && str2.length() % i == 0)
                gcd = i;
        }

        
        if (str2.length() % 2 == 0) {
            String firstHalf = str2.substring(0, gcd);
            String secondHalf = str2.substring(gcd);
            
            if (!firstHalf.equals(secondHalf)) return "";
            else if (str1.length() % str2.length() == 0) gcd = gcd * (str1.length() / str2.length());
        }

        // System.out.println("");
        System.out.println("gcd:" + gcd);

        for (int i = 0; i < str1.length(); i++) {
            int str2Index = i % gcd;
            if (str1.charAt(i) != str2.charAt(str2Index)) return "";
        }

        return str2.substring(0, gcd);
    }


    // THIS WORKS
    public String gcdOfStrings(String str1, String str2) {
        if (!(str1 + str2).equals(str2 + str1)) return "";

        int gcd = 0;
        for (int i = 1; i <= Math.min(str1.length(), str2.length()); i++) {
            if (str1.length() % i == 0 && str2.length() % i == 0)
                gcd = i;
        }

        return str1.substring(0, gcd);
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println("ABC: " + s.gcdOfStrings("ABCABC", "ABC")); // ABC
        System.out.println("AB: " + s.gcdOfStrings("ABABAB", "ABAB")); // AB
        System.out.println("ABAB: " + s.gcdOfStrings("ABABABAB", "ABAB")); // ABAB
        System.out.println(s.gcdOfStrings("LEET", "CODE"));
        System.out.println(s.gcdOfStrings("ABCDEF", "ABC"));
        System.out.println(s.gcdOfStrings("AAAAAAAAA", "AAACCC"));
    }
}
