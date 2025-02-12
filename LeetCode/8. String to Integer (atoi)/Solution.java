// Link: https://leetcode.com/problems/string-to-integer-atoi/description/

public class Solution {
    public int myAtoi(String s) {
        StringBuilder out = new StringBuilder();

        boolean hasLeadingDigit = false;
        for (char c : s.toCharArray()) {
            // ASCII of numbers 0-9: 48-57
            if (c >= 48 && c <= 57) {
                out.append(c);
                hasLeadingDigit = true;
            } else if (c == ' ') continue;
            else if (c == '+' || c == '-') {
                if (!hasLeadingDigit) {
                    out.append(c);
                } else break;
            }
            else {
                break;
            }
        }

        System.out.println("out: " + out.toString());

        return out.length() > 0 ? Integer.parseInt(out.toString()) : 0;
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        // TODO: didnt pass all test cases

        System.out.println(s.myAtoi("42"));
        System.out.println(s.myAtoi("     -42"));
        System.out.println(s.myAtoi(" -0420"));
        System.out.println(s.myAtoi("1337c0d3"));
        System.out.println(s.myAtoi("words and 987"));
        System.out.println(s.myAtoi("0-1"));
        System.out.println(s.myAtoi("-91283472332"));
    }
}
