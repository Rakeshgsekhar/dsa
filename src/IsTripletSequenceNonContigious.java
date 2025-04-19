public class IsTripletSequenceNonContigious {
    public boolean increasingTriplet(int[] nums) {
        if(nums.length<3) return false;
        
        int left = Integer.MAX_VALUE,right=Integer.MAX_VALUE;

        for(int num : nums){
            if(num<=left){
                left = num;
            }else if(num<=right){
                right = num;
            }else{
                return true;
            }
        }
        return false;

    }
}
