class SolutionFMSA {
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length-1;
        int ans = Integer.MAX_VALUE;
        while(left<=right){
            int mid = left+(right-left)/2;

            if(nums[left]<=nums[right]){
                ans = Math.min(ans,nums[left]);
                break;
            }
            if(nums[left] <= nums[mid]){
                ans = Math.min(ans,nums[left]);
                left = mid+1;
            }else{
                ans = Math.min(ans,nums[mid]);
                right = mid-1;
            }
        }
        return ans;
    }
}
public class FindMinInRotatedArray {
    public static void main(String[] args) {
        SolutionFMSA fmsa = new SolutionFMSA();
        System.out.println(fmsa.findMin(new int[]{3,4,5,1,2}));
        System.out.println(fmsa.findMin(new int[]{4,5,6,7,0,1,2}));
        System.out.println(fmsa.findMin(new int[]{11,13,15,17}));
        System.out.println(fmsa.findMin(new int[]{2,1}));
        System.out.println(fmsa.findMin(new int[]{1}));
        System.out.println(fmsa.findMin(new int[]{3,1,2}));
    }
}
