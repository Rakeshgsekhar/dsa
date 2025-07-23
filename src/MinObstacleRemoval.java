import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

class SolutionMOR {
    public int minimumObstacles(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        Deque<int[]> deque = new ArrayDeque<>();
        int[]dx = new int[]{1,0,-1,0};
        int[]dy = new int[]{0,1,0,-1};
        int[][] dis = new int[n][m];
        for(int[] row:dis) Arrays.fill(row,Integer.MAX_VALUE);
        deque.offer(new int[]{0,0,0});
        dis[0][0] = 0;

        while (!deque.isEmpty()){
            int []pos = deque.poll();
            for(int i=0;i<4;i++){
                int row = pos[0]+dx[i];
                int col = pos[1]+dy[i];
                int obstacles = pos[2];
                if(row>=0 && row<n && col>=0 && col<m ){
                    int newCount = obstacles+grid[row][col];
                    if(newCount<dis[row][col]){
                        dis[row][col] = newCount;
                        if(grid[row][col] == 1)deque.offerLast(new int[]{row,col,newCount});
                        else deque.offerFirst(new int[]{row,col,newCount});
                    }
                }
            }
        }
        return dis[n-1][m-1];
    }
}
public class MinObstacleRemoval {
    public static void main(String[] args) {
        SolutionMOR mor = new SolutionMOR();
        System.out.println(mor.minimumObstacles(new int[][]{{0,1,1},{1,1,0},{1,1,0}}));
    }
}
