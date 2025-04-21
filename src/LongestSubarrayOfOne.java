public class LongestSubarrayOfOne {
    public int longestSubarray(int[] nums) {
        int left = 0,right = 0;
        int maxOne = 0,counter = 0;
        int n = nums.length;
        int temp = 0;
        int id = 0,tmpId = 0;
        while(right<n){
            if(nums[right] == 0){
                temp++;
            }
            while(temp>1){
                if(nums[left] == 0){
                    temp--;
                }
                left++;
            }
            maxOne = Math.max(maxOne,right-left);
            right++;
        }
        return maxOne;
    }
}
