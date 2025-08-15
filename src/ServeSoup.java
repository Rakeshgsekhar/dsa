import java.util.Arrays;

class SolutionServeSoup {
    public double soupServings(int n) {
        if (n > 4800) {
            return 1.0;
        }
        double dp[][] = new double[n+1][n+1];
        for(double[] d:dp){
            Arrays.fill(d,-1);
        }

        return serve(n,n,dp);

    }
    private double serve(int cupA,int cupB, double[][] dp){
        if(cupA<=0 && cupB>0) return 1.0;
        if(cupA <= 0 && cupB <= 0) return 0.5;
        if(cupA>0 && cupB<=0) return 0.0;

        if(dp[cupA][cupB] != -1) return dp[cupA][cupB];

        double per100 = 0.25 * serve(cupA-100,cupB,dp);
        double per75 = 0.25 * serve(cupA-75,cupB-25,dp);
        double per50 = 0.25 * serve(cupA-50,cupB-50,dp);
        double per25 = 0.25 * serve(cupA-25,cupB-75,dp);

        return dp[cupA][cupB] = per100+per75+per50+per25;
    }
}
public class ServeSoup {
}
