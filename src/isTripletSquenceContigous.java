public class isTripletSquenceContigous {
    public boolean increasingTriplet(int[] nums) {
        if(nums.length<3) return false;

        for(int i = 1;i<=nums.length-2;i++){
            if(isTripletSequence(nums[i-1],nums[i],nums[i+1])) return true;
        }

        return false;

    }
    public boolean isTripletSequence(int i,int j,int k){
        if(i<j){
            if(j<k)
                return true;
        }
        return false;
    }
}
