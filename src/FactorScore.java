class SolutionFS {
    public long maxScore(int[] nums) {

        /*for(int i = 0;i< nums.length;i++){
            totalProduct*=nums[i];
        }
        long[] dp = new long[nums.length];
        for(int i = 0;i<nums.length;i++){
            dp[i] = totalProduct/nums[i];
        }

        for(int i = 0;i<dp.length;i++){
            long kd = dp[i];
            for(int j = 0;j<nums.length;j++){
                if(kd%nums[j] != 0) break;
                if(kd%nums[j] == 0){
                    factoScore = Math.min(factoScore,dp[i]);
                }
            }
        }*/
        /*
        int n = nums.length;
        if(n == 1) return nums[0]*nums[0];
        long factoScore = compute(nums,-1);
        long totalProduct = 1;
        for(int i = 0;i< nums.length;i++) {
            factoScore = Math.max(factoScore,compute(nums,i));
        }
        return factoScore;*/
        int n = nums.length;
        if(n==1) return 1l*nums[0]*nums[0];
        long factorScore = 0;
        long[] prefixLcm = new long[n];
        long[] prefixGcd = new long[n];
        long[] suffixLcM = new long[n];
        long[] suffixGcd = new long[n];

        long lcm = nums[0];
        long gcd = nums[0];

        for(int i = 0;i<n;i++){
            gcd = gcd(gcd,nums[i]);
            lcm = lcm(lcm,nums[i]);
            prefixLcm[i] = lcm;
            prefixGcd[i] = gcd;
        }
        factorScore = lcm*gcd;

        lcm = nums[n-1];
        gcd = nums[n-1];
        for(int i=n-1;i>=0;i--){
            lcm = lcm(lcm,nums[i]);
            gcd = gcd(gcd,nums[i]);
            suffixGcd[i] = gcd;
            suffixLcM[i] = lcm;
        }

        for(int i = 0;i<n;i++){
            lcm = 0;gcd = 0;
            if(i==0){
                lcm = suffixLcM[i+1];
                gcd = suffixGcd[i+1];
            }else if(i==n-1){
                lcm = prefixLcm[i-1];
                gcd = prefixGcd[i-1];
            }else{
                lcm = lcm(prefixLcm[i-1],suffixLcM[i+1]);
                gcd = gcd(prefixGcd[i-1],suffixGcd[i+1]);
            }

            factorScore = Math.max(factorScore,gcd*lcm);
        }

        return factorScore;

    }

    private long compute(int[] nums,int idx){
        int n = nums.length;
        long gcd = idx != 0 ? nums[0]:nums[1];
        long lcm = gcd;

        for (int i = (idx==0?2:1); i < n; i++) {
            if(i == idx) continue;
            long num1 = gcd;
            long num2 = nums[i];
            gcd = gcd(num1, num2);
            lcm = (lcm * nums[i]) / gcd(lcm,nums[i]);
        }
        return gcd*lcm;
    }

    private long gcd(long num1,long num2){
        if(num1 == 0) return num2;
        return gcd(num2%num1,num1);
    }

    private long lcm(long num1,long num2){
        return 1L*(num1/gcd(num1,num2))*num2; //remember
    }



}
public class FactorScore {
    public static void main(String[] args) {
        SolutionFS fs  = new SolutionFS();
        fs.maxScore(new int[]{2,4,8,16});
    }
}
