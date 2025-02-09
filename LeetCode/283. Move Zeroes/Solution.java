import java.util.Arrays;

public class Solution {
    // this solution works, but will NOT move the numbers in order
    public static void moveZeroes1(int[] nums) {
        int lastPtr = nums.length - 1;
        int i = 0;
        while (i < lastPtr) {
            if (nums[i] == 0) {
                nums[i] = nums[lastPtr];
                nums[lastPtr] = 0;
                lastPtr--;
            }
            i++;
        }
    }

    public static void moveZeroes(int[] nums) {
        int leftPtr = 0, rightPtr = 0;

        while (rightPtr < nums.length - 1) {
            rightPtr++;
            if (nums[rightPtr] != 0 && nums[leftPtr] == 0) {https://www.youtube.com/watch?v=P8qEusQiwsw&list=PLE6mZry13FnJmSj_Nl1wnzCvphQS_z_pY&index=3&pp=iAQB8AUB
                int temp = nums[leftPtr];
                nums[leftPtr] = nums[rightPtr];
                nums[rightPtr] = temp;
                leftPtr++;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {0,1,0,3,12};
        moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }
}
