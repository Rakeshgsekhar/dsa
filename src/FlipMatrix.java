class SolutionFM {
    public int[][] reverseSubmatrix(int[][] grid, int x, int y, int k) {
        //int m = grid.length;
       // int n = grid[0].length;

        int ln = y+k;
        for(int i = 0;i<k/2;i++){
            int leftr = x+i;
            int rightr = x+k-1-i;
            for(int j=y;j<ln;j++){
                int temp = grid[leftr][j];
                grid[leftr][j] = grid[rightr][j];
                grid[rightr][j] = temp;
            }
        }
        return grid;
    }

}
public class FlipMatrix {
}
