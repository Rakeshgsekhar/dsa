class SolutionMLS {
    public int maximalSquare(char[][] matrix) {
        /*if (matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int maxSquare = Integer.MIN_VALUE;
        int m = matrix.length,n=matrix[0].length;
        int[][] dp = new int[m+1][n+1];
        for(int i = 0;i<m;i++){
            dp[i][0] = 1; //matrix[i][0]-'0';
        }
        for(int i = 0;i<n;i++){
            dp[0][i] = 1;//matrix[0][i]-'0';
        }
        int maxlength = Integer.MIN_VALUE;
        for(int i = 1;i<m;i++){
            for(int j = 1;j<n;j++) {
                if (matrix[i][j] == '1') {
                    dp[i][j] = Math.min(dp[i - 1][j], Math.min(dp[i][j - 1], dp[i - 1][j - 1])) + 1;
                }
                maxlength = Math.max(maxlength,dp[i][j]);
            }
        }
        maxSquare = maxlength*maxlength;
        return maxSquare;*/
        int maxSquare = Integer.MIN_VALUE;
        int m = matrix.length,n=matrix[0].length;
        int maxlength = Integer.MIN_VALUE;
        int[][] dp = new int[m+1][n+1];
        for(int i = 0;i<m;i++){
            dp[i][0] = matrix[i][0]-'0';
            maxlength = Math.max(maxlength,dp[i][0]);
        }
        for(int i = 0;i<n;i++){
            dp[0][i] = matrix[0][i]-'0';
            maxlength = Math.max(maxlength,dp[0][i]);
        }

        for(int i = 1;i<m;i++){
            for(int j = 1;j<n;j++){
                dp[i][j] = Math.min(dp[i-1][j],Math.min(dp[i][j-1],dp[i-1][j-1]))+(matrix[i][j]-'0');
                maxlength = Math.max(maxlength,dp[i][j]);
            }
        }
        maxSquare = maxlength*maxlength;
        return maxSquare;
        //return computeMaxSquare(matrix.length-1,matrix[0].length-1,matrix.length,matrix[0].length,matrix);
    }
    private int computeMaxSquare(int row,int col,int m,int n, char[][] matrix){
        if(row<0 || col<0 ||row>=m || col>=n) return 0;
        //if(matrix[row][col] == '0') return 0;
        //else return 0;
        int top = computeMaxSquare(row-1,col,m,n,matrix);
        int left = computeMaxSquare(row,col-1,m,n,matrix);
        int diagonal = computeMaxSquare(row-1,col-1,m,n,matrix);
        int cellValue = Math.min(top,Math.min(left,diagonal))+1;
        int largestCel = Integer.MIN_VALUE;
        largestCel = Math.max(largestCel,cellValue);
        return largestCel*largestCel;

    }
}
public class MaximalSquare {

    public static void main(String[] args) {
        SolutionMLS mls = new SolutionMLS();
        System.out.println(mls.maximalSquare(new char[][]{{'1','1','1','1','1'}}));
    }
}
