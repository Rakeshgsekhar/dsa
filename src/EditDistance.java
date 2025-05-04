public class EditDistance {
    /**
     * Levenshtein distance
     * https://en.wikipedia.org/wiki/Levenshtein_distance
     */
    public int minDistance(String word1, String word2) {
        int m = word1.length(),n=word2.length();
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

        return dp[m][n];
    }
}
