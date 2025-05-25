import java.util.Arrays;

class SolutionKRSA {
    public int[] getAverages(int[] nums, int k) {
        int n = nums.length;
        int[]avg = new int[n];
        Arrays.fill(avg,-1);
        if(k>n){
            return avg;
        }
        Long[] prefixSum = new Long[n];
        prefixSum[0] =(long)nums[0];
        for(int i = 1;i<n;i++){
            prefixSum[i] = nums[i]+prefixSum[i-1];
        }


        for(int i = 0+k;i+k<n;i++){
            if(i-k>0){
                long sum = prefixSum[i+k]-prefixSum[i-k-1];
                long avgd = sum/(i+k);
                System.out.println(avgd);
                avg[i] = (int)sum/(i+k);
            }else {
                long avgd = prefixSum[i+k]/(i+k);
                System.out.println(prefixSum[i+k]);
                System.out.println(avgd);
                avg[i] = (int) (prefixSum[i+k]/(i+k));
            }
        }
        return avg;

    }
}
public class KRadusSubArrayAverage {
    public static void main(String[] args) {
        SolutionKRSA krsa = new SolutionKRSA();
        int[] result = krsa.getAverages(new int[]{7,4,3,9,1,8,5,2,6},3);

        for(int num : result) System.out.println(num);
    }
}
