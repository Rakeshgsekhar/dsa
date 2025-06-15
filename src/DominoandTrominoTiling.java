import java.util.Arrays;

public class DominoandTrominoTiling {
    public  int numTilings(int n) {
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


    private static int dominoTromino(int n){
        int [] dp = new int[n+1];
        Arrays.fill(dp,-1);

        return compute(n,dp);
    }

    private static int compute(int n,int[]dp){
        if(n<2) return 0;
        if(n==2) return 1;
//        if(n%2 != 0) return 1;
        if(dp[n]!=-1) return dp[n];

        return dp[n] = (compute(n-1,dp)+compute(n-2,dp))%1000000007;
    }

    public static void main(String[] args) {
        System.out.println(dominoTromino(6));
    }

}



