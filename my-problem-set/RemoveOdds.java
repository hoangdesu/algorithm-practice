import java.util.Arrays;

public class RemoveOdds {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int[] evens = removeOdds(nums); // [2,4,6,8,10]
        System.out.println(Arrays.toString(evens));

        System.out.println(Arrays.toString(removeOddsUsingStream(nums)));

    }

    public static int[] removeOdds(int[] nums) {
        int count = 0;
        for (int num : nums) {
            if (num % 2 == 0) count++;
        }

        int[] evens = new int[count];
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 2 == 0) {
                evens[j] = nums[i];
                j++;
            }
            
        }

        return evens;
    }

    public static int[] removeOddsUsingStream(int[] nums) {
        return Arrays.stream(nums).filter(num -> num %2 == 0).toArray();
    }

}
