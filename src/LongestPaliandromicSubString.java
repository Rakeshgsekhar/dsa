import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class SolutionLPS {

    //String longest = "";
    int max = Integer.MIN_VALUE,endI =0,st =0;
    public String longestPalindrome(String s) {
       /* int n = s.length();
        boolean[][] dp = new boolean[n][n];
        int maxLen  = 1;
        int start = 0;
        int end = 0;
        for(int i = 0;i<n;i++){
            dp[i][i] = true;
            for(int j=0;j<i;j++){
                if(s.charAt(j) == s.charAt(i) && (i-j<=2 || dp[j+1][i-1])){
                    dp[j][i] = true;
                    if(i-j+1 > maxLen){
                        maxLen = i-j+1;
                        start = j;
                        end = i;
                    }
                }
            }
        }
        return s.substring(start,end+1);
       /* Boolean[][] dp = new Boolean[n][n];
        compute(0,n-1,s,dp);
        return longest;*/

        String rs = new StringBuilder(s).reverse().toString();
        int n = s.length();
        int[][] dp = new int[n][n];
        for(int[] row:dp) Arrays.fill(row,-1);
        compute(n-1,n-1,s,rs,dp);
        return "";
    }
    private int compute(int start, int end, String s,String rs,int [][]dp){
      if(start<0 || end<0) return 0;
      if(dp[start][end] != -1) return dp[start][end];
      if(s.charAt(start)==rs.charAt(end)) dp[start][end] = 1+compute(start-1,end-1,s,rs,dp);
      else dp[start][end] = 0;
      if(dp[start][end]>max){
          endI = end;
          st = start;
          max = dp[start][end];
      }
      return dp[start][end];
    }

   /* private boolean isPalinadrom(String s){
        int left = 0;
        int right = s.length()-1;
        while(left<right){
            if(s.charAt(left) != s.charAt(right)) return false;
            left++;
            right--;
        }
        return true;
    }*/
}
public class LongestPaliandromicSubString {
    public static void main(String[] args) {
        SolutionLPS lps = new SolutionLPS();
        System.out.println(lps.longestPalindrome("aacabdkacaa"));
    }
}
