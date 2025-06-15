import java.util.Arrays;

class SolutionLPSS {
    public int longestPalindromeSubseq(String s) {
        String rs = new StringBuilder(s).reverse().toString();
        int n = s.length();
        int[][] dp = new int[s.length()+1][s.length()+1];
        for(int i = 0;i<=s.length();i++){
            dp[i][0] = 0;
            dp[0][i] = 0;
        }
        for(int i = 1;i<=s.length();i++){
            for(int j = 1;j<=s.length();j++){
                if(s.charAt(i-1) == rs.charAt(j-1)){
                    dp[i][j] = 1+ dp[i-1][j-1];
                }else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
            //Arrays.fill(dp[i],-1);
        //return compute(s.length(),rs.length(),s,rs,dp);
        return dp[n][n];
    }
    private int compute(int sd,int rsd, String s,String rs,int[][]dp){
        if(sd==0||rsd==0) return 0;
        if(dp[sd][rsd] != -1) return dp[sd][rsd];
        if(s.charAt(sd-1) == rs.charAt(rsd-1)){
            return dp[sd][rsd] = 1+compute(sd-1,rsd-1,s,rs,dp);
        }
        return dp[sd][rsd] = Math.max(compute(sd-1,rsd,s,rs,dp),compute(sd,rsd-1,s,rs,dp));
    }
}
public class LongestPaliandromicSubsequence {
    public static void main(String[] args) {
        SolutionLPSS lpss = new SolutionLPSS();
        System.out.println(lpss.longestPalindromeSubseq("bbbab"));
    }

}
