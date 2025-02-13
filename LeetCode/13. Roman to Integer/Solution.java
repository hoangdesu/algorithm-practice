// Link: https://leetcode.com/problems/roman-to-integer/description/

import java.util.HashMap;

public class Solution {
    
    public int romanToInt(String s) {
        HashMap<Character, Integer> map = new HashMap<>() {{
            put('I', 1);
            put('V', 5);
            put('X', 10);
            put('L', 50);
            put('C', 100);
            put('D', 500);
            put('M', 1000);
        }};

        int total = 0;

        int i = 0;
        while (i < s.length()) {
            char c = s.charAt(i);

            if (i < s.length() - 1) {
                char nextChar = s.charAt(i+1);
                if (c == 'I') {
                    if (nextChar == 'V') {
                        total += 4;
                        i += 2;
                        continue;
                    } else if (nextChar == 'X') {
                        total += 9;
                        i += 2;
                        continue;
                    }
                } else if (c == 'X') {
                    if (nextChar == 'L') {
                        total += 40;
                        i += 2;
                        continue;
                    } else if (nextChar == 'C') {
                        total += 90;
                        i += 2;
                        continue;
                    }
                } else if (c == 'C') {
                    if (nextChar == 'D') {
                        total += 400;
                        i += 2;
                        continue;
                    } else if (nextChar == 'M') {
                        total += 900;
                        i += 2;
                        continue;
                    }
                }
            }

            total += map.get(c);
            i++;
        }

        return total;
    }

    // TODO: optimize without using too many if-else


    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.romanToInt("III"));
        System.out.println(s.romanToInt("IV"));
        System.out.println(s.romanToInt("IX"));
        System.out.println(s.romanToInt("LVIII"));
        System.out.println(s.romanToInt("MCMXCIV"));

    }
}
