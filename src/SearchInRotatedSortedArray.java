class SolutionSRSA {
    public int search(int[] nums, int target) {
       /* int left = 0;
        int right = nums.length-1;
        while(left<=right){
            int mid = left+(right-left)/2;
            if(nums[mid] == target) return mid;
            else if(nums[left] <= nums[mid]){
                if(nums[left]<=target && target<=nums[mid]){
                    right = mid-1;
                }else{
                    left= mid+1;
                }
            }else{
                if(nums[mid]<=target && target<=nums[right]){
                    left = mid+1;
                }else{
                    right = mid-1;
                }
            }
        }
        return -1;*/
        int left = 0;
        int right = nums.length-1;
        while(left<=right){
            int mid = left+(right-left)/2;
            if(nums[mid] == target) return mid;
            else if(nums[mid] > target){
                if(nums[left]>target){
                    left = mid+1;
                }else{
                    right = mid-1;
                }
            }else{
                if(nums[left]<target){
                    right = mid-1;
                }else{
                    left = mid+1;
                }
            }
        }
        return -1;
    }
}
public class SearchInRotatedSortedArray {
    public static void main(String[] args) {
        SolutionSRSA srsa = new SolutionSRSA();
        System.out.println(srsa.search(new int[]{4,5,6,7,0,1,2},0));
        System.out.println(srsa.search(new int[]{4,5,6,7,0,1,2},5));
        System.out.println(srsa.search(new int[]{4,5,6,7,0,1,2},3));
        System.out.println(srsa.search(new int[]{1,2,0},0));
        System.out.println(srsa.search(new int[]{2,0},-1));

    }

}
