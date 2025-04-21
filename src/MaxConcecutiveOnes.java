public class MaxConcecutiveOnes {
    public int longestOnes(int[] nums, int k) {
        int left = 0,right = 0;
        int maxOne = 0,counter = 0;
        int n = nums.length;
        int temp = 0;
        int[] zero = new int[n];
        int id = 0,tmpId = 0;
        while(right<n){
            if(nums[right] == 0){
                temp++;
            }
            while(temp>k){
                if(nums[left] == 0){
                    temp--;
                }
                left++;
            }
            maxOne = Math.max(maxOne,right-left+1);
            right++;
        }
        return maxOne;
    }
}
