import java.util.Arrays;

public class MinOpertionsZero {
    static class SolutionZero {
        public int minOperations(int[] nums) {
            Arrays.sort(nums);
            int count = 0;
            int left = 1;
            int num = 0;
            while(left<nums.length){
                if(nums[left] == 0){
                    left++;
                }
                else if(nums[left] == num){
                    nums[left] = 0;
                    left++;
                }else if(nums[left] != num){
                    num = nums[left];
                    count++;
                }
            }

            return count;
        }
    }

    public static void main(String[] args) {
        SolutionZero sz = new SolutionZero();

        int[] nums = new int[]{3,1,2,1};
        int[] nums2 = new int[]{0,2};

        System.out.println(sz.minOperations(nums));
        System.out.println(sz.minOperations(nums2));
    }
}
