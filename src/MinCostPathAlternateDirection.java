class SolutionMCAP {
    public final static long INF = (long)1e15;
    public long minCost(int m, int n, int[][] waitCost) {
        long[] cost = new long[]{0l};
        long[][][] dp = new long[m][n][2];
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                dp[i][j][0] = dp[i][j][1] = -1L;
        return compute(waitCost,m,n,0,0,0,dp);
    }

    private long compute(int[][] waitCoast,int m,int n,int sec,int i,int j, long[][][] dp){
        /*if(i<0||j<0 || i>=m|| j>=n ) return 0l;

        if(sec%2 == 0){
            cost+=(i+1)*(j+1);
            long right = compute(waitCoast,m,n,sec+1,cost,i+1,j);
            long down = compute(waitCoast,m,n,sec+1,cost,i,j+1);
            cost+=Math.min(right,down);
        }else{
            cost+=waitCoast[i][j];
            long right = compute(waitCoast,m,n,sec+1,cost,i+1,j);
            long down = compute(waitCoast,m,n,sec+1,cost,i,j+1);
        }
        return cost;*/
        if(i == m-1 && j == n-1) return 0;
        if(i<0||j<0||i>=m||j>=n) return INF;
        long cost = INF;
        if(sec == 1){
            cost = Math.min(cost,(long)((i+2)*(j+1))+compute(waitCoast,m,n,0,i+1,j,dp));
            cost = Math.min(cost,(long)((i+1)*(j+2))+compute(waitCoast,m,n,0,i,j+1,dp));
        }else{
            cost = Math.min(cost,waitCoast[i][j]+compute(waitCoast,m,n,1,i,j,dp));
        }
        dp[i][j][sec] =  cost;
        return cost;

    }
}
public class MinCostPathAlternateDirection {
    public static void main(String[] args) {
        SolutionMCAP mc = new SolutionMCAP();
        long cst = mc.minCost(1,2,new int[][]{{1,2}});
        System.out.println(cst);
    }
}
