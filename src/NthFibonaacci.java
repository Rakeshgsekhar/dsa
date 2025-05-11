import java.util.Arrays;

public class NthFibonaacci {
    public static int fintNth(int n){
        if(n<=1) return n;

        return fintNth(n-1)+fintNth(n-2);
    }

    public static long[] dp;
    public static long findNth(int n){
        if(dp[n] != -1 ) return dp[n];
        return dp[n] = findNth(n-1)+findNth(n-2);
    }

    public static void main(String[] args) {
        dp = new long[100];
        Arrays.fill(dp,-1);
        dp[0] = 0;
        dp[1] = 1;
        System.out.println(System.currentTimeMillis());
        System.out.println(fintNth(20));
        System.out.println(System.currentTimeMillis());


        System.out.println("*****************************");
        System.out.println(System.currentTimeMillis());
        System.out.println(findNth(99));
        System.out.println(System.currentTimeMillis());

    }
}
