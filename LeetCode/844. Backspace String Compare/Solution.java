// https://leetcode.com/problems/backspace-string-compare/description/

import java.util.Stack;

public class Solution {
    // Comparing 2 stacks: O(n), using extra space for 2 stacks
    public boolean backspaceCompare(String s, String t) {
        Stack<Character> stack1 = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c != '#') {
                stack1.add(c);
            } else {
                if (!stack1.empty()) stack1.pop();
            }
        }

        Stack<Character> stack2 = new Stack<>();
        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            if (c != '#') {
                stack2.add(c);
            } else {
                if (!stack2.empty()) stack2.pop();
            }
        }

        return stack1.equals(stack2);
    }

    // TODO: use 2 pointers solution: https://www.youtube.com/watch?v=6lOXjqmEAgg&ab_channel=TiCungBimDSA
    
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.backspaceCompare("ab#c", "ad#c")); // true
        System.out.println(s.backspaceCompare("ab##", "c#d#")); // true
        System.out.println(s.backspaceCompare("a#c", "b")); // false
    }
}
