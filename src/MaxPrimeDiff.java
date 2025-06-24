
class SolutionMPD {
    public int maximumPrimeDifference(int[] nums) {
        boolean[] isPrime = seivePrime(100);
        int left = 0;
        int right = nums.length-1;

        for(int i = 0;i<nums.length;i++){
            if(isPrime[nums[i]]){
                left = i;
                break;
            }
        }

        for(int i = nums.length-1;i>=0;i--){
            if(isPrime[nums[i]]){
                right = i;
                break;
            }
        }
        return right-left;
    }
    private boolean[] seivePrime(int n){
        boolean prime[] = new boolean[n + 1];
        for (int i = 0; i <= n; i++)
            prime[i] = true;

        for (int p = 2; p * p <= n; p++) {
            if (prime[p] == true) {
                for (int i = p * p; i <= n; i += p)
                    prime[i] = false;
            }
        }
        return prime;
    }
}
public class MaxPrimeDiff {
}
