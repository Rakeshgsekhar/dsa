class SolutionITP {
    public boolean increasingTriplet(int[] nums) {

        if(nums.length<3) return false;
        int n = nums.length;
        /* Brutforce
        for(int i = 0 ;i<n;i++){
            for(int j = i+1;j<n;j++){
                for(int k = j+1;k<n;k++){
                    if((i<j) && (j<k) && (nums[i]<nums[j]) && (nums[j]<nums[k])) return true;
                }
            }
        }
        return false;

        */
        int left = Integer.MAX_VALUE,right = Integer.MAX_VALUE;

        for(int i = 0;i<n;i++){
            if(nums[i]<=left){
                left = nums[i];
            }else if(nums[i]<=right){
                right = nums[i];
            }else{
                return true;
            }
        }
        return false;
        /*
        takes first value compare it left if less than left set it and if false it checks if
        5,4,3,2,1
        5 is less than left , left = 5,
        4 greater than 5 left hen In Max, right -> 4
        now algorithm search for a value less then 5 and less than 4 to set the sequence as false. we are looking for increasing subsequence.
        As per the algo, if everything is decreasing it will send false;

         */
    }
}
public class IncreasingTipleet {
}
