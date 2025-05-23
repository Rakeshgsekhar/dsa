import java.util.List;

class SolutionNGI {
    public int nextGreaterElement(int n) {
        String num = String.valueOf(n);
        int[] nums = new int[num.length()];

        int index = 0;
        for(char ch : num.toCharArray()){
            nums[index++] = ch-'0';
        }
        return nextPermutation(nums);
    }

    public int nextPermutation(int[] nums) {
        int breakIndex = -1,n = nums.length;
        for(int i = n-2;i>=0;i--){
            if(nums[i] < nums[i+1]){
                breakIndex = i;
                break;
            }
        }
        if(breakIndex == -1){
            return -1;
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
        int val = 0;
        StringBuilder sbr = new StringBuilder();
        for(int num:nums){
            val = (val*10) + num;
            sbr.append(num);
        }
        if(!sbr.toString().equals(String.valueOf(val))) return -1;
        return val>=0?val:-1;
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
public class NextGreatInteger {
    public static void main(String[] args) {
        SolutionNGI ngi = new SolutionNGI();
        int[] inp = new int[]{1,10001,1099011,230241,2147483647,2147483486,117722222,111177777,888887771,111000222, 99999999,1020040,887755443,1999999999};//9988776655
        for(int in : inp)
            System.out.println(ngi.nextGreaterElement(in));

//        System.out.println(ngi.nextGreaterElement(1999999999));
    }
}
