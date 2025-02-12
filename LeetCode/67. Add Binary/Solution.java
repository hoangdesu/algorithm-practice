// Link: 

// TODO: didnt pass

public class Solution {
    public String addBinary(String a, String b) {
        int aPtr = a.length() - 1;
        int bPtr = b.length() - 1;

        StringBuilder binary = new StringBuilder();

        boolean carried = false;
        while (aPtr > 0 && bPtr > 0) {
            
            if (a.charAt(aPtr) == '1' && b.charAt(bPtr) == '1') {
                carried = true;
                binary.insert(0, '0');
            }

            if (carried) {
                if (a.charAt(aPtr) == '0' && b.charAt(bPtr) == '0') {
                    binary.insert(0, '1');
                    carried = false;
                }
            } else {
                binary.insert(0, '1');
            }
            
            System.out.println("a: " + a.charAt(aPtr));
            System.out.println("b: " + b.charAt(bPtr));

            aPtr--;
            bPtr--;
        }

        return binary.toString();
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.addBinary("11", "1"));
        System.out.println(s.addBinary("1010", "1011"));
    }
}
