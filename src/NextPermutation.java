
class SolutionNP {
    public void nextPermutation(int[] nums) {
        int breakIndex = -1,n = nums.length;
        for(int i = n-2;i>=0;i--){
            if(nums[i] < nums[i+1]){
                breakIndex = i;
                break;
            }
        }
        if(breakIndex == -1){
            reverseArr(nums,0,n-1);
            return;
        }
        int nextMax = nums[breakIndex];
        int nextMaxIndex = n-1;
        for(int i = n-1;i>breakIndex;i--){
            if(nextMax<nums[i]){
                nextMax=nums[i];
                nextMaxIndex = i;
                break;
            }
        }

        int temp = nums[nextMaxIndex];
        nums[nextMaxIndex] = nums[breakIndex];
        nums[breakIndex] = temp;

        reverseArr(nums,breakIndex+1,n-1);
    }

    private void reverseArr(int[] arr,int start,int end){
        while(start<end){
            int temp = arr[end];
            arr[end] = arr[start];
            arr[start] = temp;
            start++;
            end--;
        }
    }
}
public class NextPermutation {
    public static void main(String[] args) {
        SolutionNP np = new SolutionNP();
        int[]nums = new int[]{2,3,0,2,4,1};

        np.nextPermutation(nums);


        for(int n:nums)
            System.out.println(n);
    }
}
