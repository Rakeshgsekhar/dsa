import java.util.ArrayList;
import java.util.List;

class SolutionCI {
    // Function to count inversions in the array.
   /* public int inversionCount(int arr[]) {
        // Your Code Here
        int count = 0;
        int n = arr.length;
        for(int i = 0;i<=n-2;i++){
            for(int j = i+1;j<=n-1;j++){
                if(arr[i]>arr[j]) count++;
            }
        }
        return count;

    }*/

    static int inversionCount(int nums[]) {
        // Your Code Here
        //int count = 0;
        // int n = arr.length;
        // for(int i = 0;i<=n-2;i++){
        //     for(int j = i+1;j<=n-1;j++){
        //         if(arr[i]>arr[j]) count++;
        //     }
        // }
        //return count;
        int count = mergeSort(0,nums.length-1,nums);
        return count!=0? count+1:0;
    }

    public int countInversionMergeSort(int[] nums){
        int count = mergeSort(0,nums.length-1,nums);
        return count!=0? count+1:0;
    }

    private static int mergeSort(int left, int right, int[] nums){
        if(left>=right) return 0;
        int mid = left+ (right-left)/2;
        int firstHalf = mergeSort(left,mid,nums);
        int secondHalf = mergeSort(mid+1,right,nums);
        int full = merge(nums,left,mid,right);
        return firstHalf+secondHalf+full;
    }

    private static int merge(int[] nums, int left, int mid, int right){
        int count = 0;
        int low = left;
        int high = mid+1;

        List<Integer> temp = new ArrayList<>();
/*
        System.arraycopy(nums,left,leftArray,0,n1);
        System.arraycopy(nums,mid+1,rightArray,0,n2);
*/
//        int i = 0 ,j = 0, index = left;
/*
        while(i<n1 && j<n2 ){
            if(leftArray[i] <= rightArray[j]){
                nums[index++] = leftArray[i++];

            }else{
                nums[index++] = rightArray[j++];
                count++;
            }
        }

        while(i<n1){
            nums[index++] = leftArray[i++];
        }

        while(j<n2){
            nums[index++] = rightArray[j++];
        }*/

        while(low<=mid && high<=right){
            if(nums[low]<=nums[high]){
                temp.add(nums[low++]);
            }else{
                temp.add(nums[high++]);
                count+=mid-low+1;
            }
        }

        while(low<=mid){
            temp.add(nums[low]);
            low++;
        }
        while(high<=right){
            temp.add(nums[high]);
            high++;
        }
        for(int i = low;i<=right;i++){
            nums[i] = temp.get(i-low);
        }
        return count;
    }



}
public class CountInversion {
    public static void main(String[] args) {
        SolutionCI ci = new SolutionCI();
        int[] arr = new int[]{2, 4, 1, 3, 5};
        System.out.println(ci.countInversionMergeSort(arr));
        System.out.println(ci.countInversionMergeSort(new int[]{1,2,3,4,5,6,7}));
        System.out.println(ci.countInversionMergeSort(new int[]{10,10,10}));
    }
}
