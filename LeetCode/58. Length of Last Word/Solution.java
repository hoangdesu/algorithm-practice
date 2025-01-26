class Solution {
    public static int lengthOfLastWord(String s) {
        int len = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            char c = s.charAt(i);
            if (len == 0 && c == ' ') continue;
            
            if (c == ' ') {
                return len;
            } else {
                len++;
            }
        }
        return len;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLastWord("Hello World"));
    }
}