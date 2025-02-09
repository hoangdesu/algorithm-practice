import java.util.HashMap;
import java.util.Stack;

public class Solution {
    public static void main(String[] args) {
        System.out.println(isValid("([]) => {}"));
        System.out.println(isValid("()[]{}"));
        System.out.println(isValid("(]"));

    }

    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        HashMap<Character, Character> pairs = new HashMap<>();

        // use the popped value as the key to get the oppening brace
        pairs.put(')', '(');
        pairs.put(']', '[');
        pairs.put('}', '{');

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '{' || c == '[') {
                stack.add(c);
                System.out.println("Current stack: " + stack);
            } else if (c == ')' || c == '}' || c == ']') {
                if (stack.isEmpty())
                    return false;
                Character popped = stack.pop();
                System.out.println("Popped: " + popped);
                System.out.println("pair: " + pairs.get(c));

                if (popped != pairs.get(c))
                    return false;
            }
        }

        System.out.println("Stack after: " + stack.toString());
        if (!stack.isEmpty())
            return false;

        return true;

    }
}
