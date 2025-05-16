
class SolutionSort {
    public int[] sortArray(int[] nums) {
        quickSort(0,nums.length-1,nums);
        return nums;
    }
    private void quickSort(int low,int high,int[] nums){
        if(low<high){
            int partitionIndex = findPIndex(low , high,nums);

            quickSort(low,partitionIndex-1,nums);
            quickSort(partitionIndex+1,high,nums);
        }
        return;
    }

    private int findPIndex(int low, int high,int[] nums){
        int pivotEle = nums[low];
        int i = low;
        int j = high;
        while(i<j){
            while(nums[i] <=pivotEle && i<=high-1){
                i++;
            }
            while(nums[j] > pivotEle && j>=0){
                j--;
            }

            if(i<j){
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            }
        }
        nums[low] = nums[j];
        nums[j] = pivotEle;
        return j;
    }

    public int[] sortM(int[] nums){
        mergeSort( 0,nums.length-1,nums);
        return nums;
    }

    private void mergeSort(int left,int right,int[] nums){
        if(left>=right) return;
        int mid = left+ (right-left)/2;
        mergeSort(left,mid,nums);
        mergeSort(mid+1,right,nums);
        merge(nums,left,mid,right);
    }

    private void merge(int[] nums,int left,int mid, int right){
        int n1 = mid-left+1;
        int n2 = right - mid;
        int[] leftArray = new int[n1];
        int[] rightArray = new int[n2];

        System.arraycopy(nums,left,leftArray,0,n1);
        System.arraycopy(nums,mid+1,rightArray,0,n2);

        int i = 0 ,j = 0, index = left;

        while(i<n1 && j<n2 ){
            if(leftArray[i] < rightArray[j]){
                nums[index++] = leftArray[i++];

            }else{
                nums[index++] = rightArray[j++];
            }
        }

        while(i<n1){
            nums[index++] = leftArray[i++];
        }

        while(j<n2){
            nums[index++] = rightArray[j++];
        }
    }

    public int[] sortHeap(int[] nums){

        int n = nums.length;

        for(int i = n/2-1;i>=0;i--)
            heapify(nums,n,i);

        for(int i = n-1;i>=0;i--){
            int temp = nums[i];
            nums[i]=nums[0];
            nums[0] = temp;

            heapify(nums,i,0);

        }

        return nums;
    }

    private void heapify(int [] nums,int n,int i){
        int parent = i;
        int leftChild = 2*parent+1;
        int rightChild = 2*parent+2;

        if(leftChild<n && nums[leftChild]> nums[parent]){
            parent = leftChild;
        }

        if(rightChild<n && nums[rightChild]>nums[parent]){
            parent = rightChild;
        }

        if(parent != i){
            int temp = nums[i];
            nums[i] = nums[parent];
            nums[parent] = temp;

            heapify(nums,n,parent);
        }


    }


}
public class SortArray {
    public static void main(String[] args) {
        SolutionSort sort = new SolutionSort();
        int[] nums = new int[]{4,6,2,5,7,9,1,3};
        int[] nums2 = new int[]{4,6,2,5,7,9,1,3};

        int[]nums3 = new int[]{4,6,2,5,7,9,1,3};
        System.out.println(System.currentTimeMillis());
        sort.sortArray(nums);
        System.out.println(System.currentTimeMillis());

        for(int n : nums)
            System.out.println(n);

        System.out.println("***********************");
        System.out.println(System.currentTimeMillis());
        sort.sortM(nums2);
        System.out.println(System.currentTimeMillis());

        for(int n : nums2)
            System.out.println(n);

        System.out.println("***********************");
        System.out.println(System.currentTimeMillis());
        sort.sortHeap(nums3);
        System.out.println(System.currentTimeMillis());

        for(int n : nums3)
            System.out.println(n);
    }
}
