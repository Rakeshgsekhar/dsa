import java.util.Arrays;

class SolutionNT{
    public int maxScore(int[][] ninjaT){
        int n = ninjaT.length;
        int tasks = ninjaT[0].length;
        int[][] dp = new int[n][tasks+1];
        for(int i = 0;i<n;i++)
            Arrays.fill(dp[i],-1);

        return findMaxScore(n-1,tasks,tasks,dp,ninjaT);
    }

    public int maxScoreTB(int[][]val){
        return findScoreTB(val);
    }

    private int findMaxScore(int day,int task,int totalTasks, int[][]dp,int[][]val){
        if(day==0){
            int max = 0;
            for(int i = 0;i<totalTasks;i++){
                if(i!=task){
                    max = Math.max(max,val[day][i]);
                }
            }
            return max;
        }
        if(dp[day][task] != -1) return dp[day][task];

        int max = 0;
        for(int i = 0;i<totalTasks;i++){
            if(i!=task){
                int points = val[day][i]+ findMaxScore(day-1,i,totalTasks,dp,val);
                max = Math.max(max,points);
            }
        }
        return dp[day][task]=max;
    }


    private int findScoreTB(int[][]val){
        int n = val.length;
        int t = 0;
        int[][] dp = new int[n][val[0].length+1];
        while(t<val[0].length) {
            int max = 0;
            for (int i = 0; i < val[0].length; i++) {
                if (i!=t){
                    max = Math.max(max,val[0][i]);
                }
            }
            dp[0][t++] = max;
        }
        int max = 0;
        for(int i = 0;i<val[0].length;i++){
            max = Math.max(max,val[0][i]);
        }

        dp[0][val[0].length] = max;

        for(int day = 1;day<n;day++){
            for(int last = 0 ; last<=val[0].length;last++){
                dp[day][last] = 0;
                int maxPoints = 0;
                for(int task = 0;task<val[0].length;task++){
                    if(task!=last){
                        int points =  val[day][task]+ dp[day-1][task] ;
                        maxPoints = Math.max(maxPoints,points);
                    }
                }
                dp[day][last] = maxPoints;
            }
        }

        return dp[n-1][val[0].length];
    }
}
public class NinjaTraining {

    public static void main(String[] args) {
        int[][] nt = new int[][]{{18,11,19},{4,13,7},{1,8,13}};
        SolutionNT solutionNT = new SolutionNT();
        System.out.println(solutionNT.maxScore(nt));
        System.out.println(solutionNT.maxScoreTB(nt));
    }

}
