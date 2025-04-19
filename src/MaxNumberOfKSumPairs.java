import java.util.Arrays;

public class MaxNumberOfKSumPairs {
    public int maxOperations(int[] nums, int k) {
        /*
        the below solution solves without sorting but cause time limit exception
        int left = 0,right = 1;
        int operations = 0;
        if(nums.length == 1) return 0;

        while(left<nums.length){
          //System.out.println(left+"-"+right);
            if(left<nums.length && right<nums.length && nums[left] != 0 && nums[right]!=0 && nums[left]+nums[right] == k && left != right) {
                operations++;
                nums[left] = 0;
                nums[right] = 0;
                left++;
                right = left+1;
            }else{
                right++;
            }
             if(right>=nums.length){
                left++;
                right = left+1;
            }



        }
        return operations;
        */

        Arrays.sort(nums);

        int left = 0,right = nums.length-1;
        int count = 0;
        while(left<right){
            int sum = nums[left]+nums[right];
            if(sum==k){
                count++;
                left++;
                right--;
            }else if(sum<k){
                left++;
            }else{
                right--;
            }
        }
        return count;
    }
}
