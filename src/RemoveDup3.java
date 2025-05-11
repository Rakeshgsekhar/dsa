

class SolutionRD3 {
    public int removeDuplicates(int[] nums) {
        if(nums.length <= 3) return nums.length;
        int n = nums.length;
        int result = 3;
        /***Since we need  atmost a number twice and the array is sorted we will start from result = 2;
         we will have an index j that start from 2 and iterate through the array in the for loop.
         [1,1,[1],2,2,3]

         modifiyabel for 3 ,4,n consecutive as required
         what ever j points is the current element, we compare it with result-2, if same increment j
         if not same replace k with j element and increment k;
         */
        for(int j = 3;j<n;j++){
            if(nums[j]!=nums[result-3]){
                nums[result++] = nums[j];
            }
        }
        return result;
    }
}
public class RemoveDup3 {
    public static void main(String[] args) {
        SolutionRD3 sr = new SolutionRD3();

        int[] arr = new int []{1,1,1,1,1,2,2,2,2,3,3,3,4,4};
        int k = sr.removeDuplicates(arr);

        System.out.print("[");
        for(int i = 0;i<k;i++){
            System.out.print(arr[i]);
            System.out.print(",");
        }
        System.out.print("]");
    }
}
