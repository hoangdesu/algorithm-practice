// Link: 

import java.util.Set;

public class Solution {
    public String reverseVowels(String s) {
        int head = 0, tail = s.length() - 1;
        Set<Character> vowels = Set.of('a', 'i', 'u', 'e', 'o');
        
        char[] res = s.toCharArray();

        while (head < tail) {
            char headChar = res[head];
            char tailChar = res[tail];

            // System.out.printf("head=%d, tail=%d, headChar=%c, tailChar=%c\n", head, tail, headChar, tailChar);

            // => using guard clauses
            if (!vowels.contains(Character.toLowerCase(headChar))) {
                head++;
                continue;
            }

            if (!vowels.contains(Character.toLowerCase(tailChar))) {
                tail--;
                continue;
            }
            
            // this check is not too necessary
            if (vowels.contains(Character.toLowerCase(headChar)) && vowels.contains(Character.toLowerCase(tailChar))) {
                char temp = res[head];
                res[head] = res[tail];
                res[tail] = temp;
                head++;
                tail--;
            }
            
            // avoid using nested conditions -> hard to read
            // if (vowels.contains(headChar)) {
            //     if (vowels.contains(tailChar)) {
            //         char temp = res[head];
            //         res[head] = res[tail];
            //         res[tail] = temp;
            //         head++;
            //         tail--;
            //     } else {
            //         tail--;
            //     }
            // } else {
            //     head++;
            // }
        }

        return String.valueOf(res);
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.reverseVowels("leetcode"));
        System.out.println(s.reverseVowels("IceCreAm"));
    }
}
