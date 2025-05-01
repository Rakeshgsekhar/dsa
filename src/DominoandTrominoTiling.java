public class DominoandTrominoTiling {
    public int numTilings(int n) {
        /**
         a[0] = 1 //
         a[1] = 2 //  combination
         a[2] = 5; two face one tile

         */
        long[] dp = new long[n+3];

        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;
        for(int i = 3;i<=n;i++){
            dp[i] = (2*dp[i-1] + dp[i-3]) % 1000000007;
        }

        return (int)dp[n];
    }
}
