class SolutionLRL {
    public int[] searchRange(int[] nums, int target) {
        int[] result = new int[]{-1,-1};
        result[0] = getLimit(nums,target,true);
        result[1] = getLimit(nums,target,false);

        return result;
    }
    private int getLimit(int[] nums,int target,boolean isLeft){
        int left = 0;
        int right = nums.length-1;
        int index = -1;
        while(left<=right){
            int mid = left+(right-left)/2;
            if(nums[mid] == target){
                index = mid;
                if(isLeft)right = mid-1;
                else left = mid+1;
            }else if(nums[mid] < target){
                left = mid+1;
            }else{
                right = mid-1;
            }
        }
        return index;
    }
}
public class LeftAndRightLimit {
    public static void main(String[] args) {
        SolutionLRL lrl = new SolutionLRL();
        int[] r = lrl.searchRange(new int[]{5,7,7,8,8,10},8);
        for(int l : r){
            System.out.println(l);
        }
    }
}
