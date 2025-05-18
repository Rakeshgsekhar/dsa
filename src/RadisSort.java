import java.util.Arrays;

class SortRadix{
    public int[] radixSort(int[] nums){
        int max = Arrays.stream(nums).max().getAsInt();
        for(int exp = 1;max/exp > 0; exp*=10){
            countSort(nums,exp,max);
        }

        return nums;
    }

    private void countSort(int[] nums,int exp,int max){
        int n = nums.length;
        int[] count = new int[10];
        int[] result = new int[n];
        for(int i = 0;i<n;i++){
            count[(nums[i]/exp)%10]++;
        }

        for (int i  =1 ;i<10;i++){
            count[i] = count[i]+count[i-1];
        }

        for(int i = n-1;i>=0;i--){
            result[count[(nums[i]/exp)%10]-1] = nums[i];
            count[(nums[i]/exp)%10]--;
        }

        System.arraycopy(result,0,nums,0,n);

    }

}
public class RadisSort {

    public static void main(String[] args) {
        int[]nums4 = new int[]{10,49,2,5,7,9,1,3};
        SortRadix sort = new SortRadix();
        System.out.println("***********************");
        System.out.println(System.currentTimeMillis());
        sort.radixSort(nums4);
        System.out.println(System.currentTimeMillis());

        for(int n : nums4)
            System.out.println(n);
    }
}
