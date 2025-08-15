class SolutionNWRSP {
    public int numberOfWays(int n, int x) {
        long[] dp = new long[n+1];
        dp[0] = 0;
        for(int i = 1;Math.pow(i,x)<=n;i++){
            int power = (int) Math.pow(i,x);
            for(int j = n;j>=power;j--){
                dp[j] = (dp[j]-dp[j-power])%(int)1e7;
            }
        }
        return (int)dp[n];
    }
}
public class NumberOfWaysRepresnetSumOfPower {
}
