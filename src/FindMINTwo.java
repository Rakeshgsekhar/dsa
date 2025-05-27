class SolutionFMSA2 {
    public int findMin(int[] nums) {
        /*int ans  = Integer.MAX_VALUE;
        for(int i = 0;i<nums.length;i++){
            if(nums[i]<ans){
                ans = nums[i];
            }
        }
        return ans;*/
        int left = 0,right = nums.length-1;
        while(left<right){
            int mid = left+(right-left)/2;
            if(nums[mid]>nums[right]){
                left = mid+1;
            }else if(nums[mid] < nums[right]){
                right = mid;
            }else{
                right--;
            }
        }
        return nums[left];
    }
}
public class FindMINTwo {
}
