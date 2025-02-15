// Link: https://leetcode.com/problems/removing-stars-from-a-string/description/?envType=study-plan-v2&envId=leetcode-75

import java.util.Stack;
import java.util.stream.Collectors;

public class Solution {
    public String removeStars(String s) {
        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (c != '*') {
                stack.add(c);
            } else {
                stack.pop();
            }
        }

        return stack.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(""));
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.removeStars("leet**cod*e"));
        System.out.println(s.removeStars("erase*****"));

    }
}
