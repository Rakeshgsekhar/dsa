import java.util.Arrays;

class SolutionEDT{
    public int minDistance(String word1, String word2) {
        /*int m = word1.length(),n=word2.length();
        if(m==0) return n;
        if(n==0) return m;
        if(word1.equals(word2)) return 0;

        int[][]dp = new int[m+1][n+1];

        for(int i = 1;i<=m;i++){
            dp[i][0] = i;
        }

        for(int i = 1;i<=n;i++){
            dp[0][i] = i;
        }

        int substitutionCost = 0;
        for(int j =1;j<=n;j++){
            for(int i = 1;i<=m;i++){
                if(word1.charAt(i-1) == word2.charAt(j-1)){
                    substitutionCost = 0;
                }else{
                    substitutionCost = 1;
                }
                dp[i][j] = Math.min(dp[i-1][j]+1,Math.min(dp[i][j-1]+1,dp[i-1][j-1]+substitutionCost));
            }
        }

        return dp[m][n];*/
        int n = word1.length();
        int m = word2.length();
        if(n== 0) return m;
        if(m==0) return n;
        if(word1.equals(word2)) return 0;
        int[][] memo = new int[n][m];
        for(int i = 0;i<n;i++){
            Arrays.fill(memo[i],-1);
        }
       // return minDistanceRecMemo(n-1,m-1,word1,word2,memo);
         return minDistanceRecMemoP(0,m-1,word1,word2,memo);
    }

    private int minDistanceRec(int wd1,int wd2,String word1,String word2){
        if(wd1<0){
            return wd2;
        }
        if(wd2<0) return wd1;

        if(word1.charAt(wd1) == word2.charAt(wd2)){
            return 1+minDistanceRec(wd1-1,wd2-1,word1,word2);
        }

        int insert = minDistanceRec(wd1-1,wd2,word1,word2);
        int delete = minDistanceRec(wd1,wd2-1,word1,word2);
        int replace = minDistanceRec(wd1-1,wd2-1,word1,word2);

        return 1+Math.min(insert,Math.min(delete,replace));
    }

    private int minDistanceRecMemo(int wd1,int wd2,String word1,String word2,int[][]memo){
        if(wd1<0){
            return wd2+1;
        }
        if(wd2<0) return wd1+1;
        if(memo[wd1][wd2] != -1) return memo[wd1][wd2];
        if(word1.charAt(wd1) == word2.charAt(wd2)){
            return memo[wd1][wd2]= minDistanceRec(wd1-1,wd2-1,word1,word2);
        }

        int insert = minDistanceRec(wd1-1,wd2,word1,word2);
        int delete = minDistanceRec(wd1,wd2-1,word1,word2);
        int replace = minDistanceRec(wd1-1,wd2-1,word1,word2);

        return memo[wd1][wd2]=1+Math.min(insert,Math.min(delete,replace));
    }
    private int minDistanceRecMemoP(int wd1,int wd2,String word1,String word2,int[][]memo){
        if(wd1>=word1.length()){
            return word2.length()-wd1;
        }
        if(wd2<0) return word1.length()-wd1;
        if(memo[wd1][wd2] != -1) return memo[wd1][wd2];
        if(word1.charAt(wd1) == word2.charAt(wd2)){
            return memo[wd1][wd2]= minDistanceRecMemoP(wd1+1,wd2-1,word1,word2,memo);
        }

        int insert = minDistanceRecMemoP(wd1+1,wd2,word1,word2,memo);
        int delete = minDistanceRecMemoP(wd1,wd2-1,word1,word2,memo);
        int replace = minDistanceRecMemoP(wd1+1,wd2-1,word1,word2,memo);

        return memo[wd1][wd2]=1+Math.min(insert,Math.min(delete,replace));
    }
}
public class EditDistance {
    /**
     * Levenshtein distance
     * https://en.wikipedia.org/wiki/Levenshtein_distance
     */

    public static void main(String[] args) {
        SolutionEDT edit = new SolutionEDT();
        String s = "leetcode";
        String rs = s+new StringBuilder(s).reverse().toString();
        System.out.println(edit.minDistance(s,rs));
    }
}
