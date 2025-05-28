import java.util.Arrays;

class SolutionPWME {
    private int[] directions_x = {0, 1, -1, 0};  // Changes in x coordinate for four directions
    private int[] directions_y = {1, 0, 0, -1};
    public int minimumEffortPath(int[][] heights) {
        int[] minMax = getMinMax(heights);
        int min = 0;
        int max = minMax[1];
        int n = heights.length,m=heights[0].length;
        boolean[][] visited = new boolean[n][m];

        while(min<max){
            int mid = min+(max-min)/2;
            for(int i = 0;i<n;i++){
                Arrays.fill(visited[i],false);
            }
            isPathPossible(0,0,heights,mid,visited);
            if(visited[n-1][m-1]){
                max = mid;
            }else{
                min = mid+1;
            }
        }
        return min;
    }

    private int[] getMinMax(int[][]heights){
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for(int i = 0;i<heights.length;i++){
            for(int j = 0;j<heights[0].length;j++){
                min = Math.min(min,heights[i][j]);
                max = Math.max(max,heights[i][j]);
            }
        }

        return new int[]{min,max-min};
    }


    private void isPathPossible(int row,int col, int[][] heights,int threshold,boolean[][] visited){
        if(row<0 || col<0 || row>=heights.length || col>=heights[0].length) return ;
        if(visited[row][col]) return;
        visited[row][col] = true;
        for(int i = 0;i<4;i++){
            int new_row = row + directions_x[i];
            int new_col = col + directions_y[i];

            if(new_row<0 || new_col<0 || new_row>=heights.length || new_col>=heights[0].length) continue;

            int effort = Math.abs(heights[new_row][new_col]-heights[row][col]);
            if(effort<=threshold)
                isPathPossible(new_row,new_col,heights,threshold,visited);
        }
    }
}
public class PathWithMinEffor {

    public static void main(String[] args) {
        SolutionPWME path = new SolutionPWME();
        System.out.println(path.minimumEffortPath(new int[][]{{1,2,2},{3,8,2},{5,3,5}}));
        System.out.println(path.minimumEffortPath(new int[][]{{1,2,3},{3,8,4},{5,3,5}}));
        System.out.println(path.minimumEffortPath(new int[][]{{1,2,1,1,1},{1,2,1,2,1},{1,2,1,2,1},{1,2,1,2,1},{1,1,1,2,1}}));
    }
}
