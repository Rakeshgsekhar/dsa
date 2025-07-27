import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

class SolutionMCVALP {
    public int minCost(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] weightedGraph = new int[m][n];
        int[][]cost = new int[m][n];
        for(int[] row:cost) Arrays.fill(row,Integer.MAX_VALUE);
        int[]dx = new int[]{0,0,1,-1};
        int[]dy = new int[]{1,-1,0,0};
        Deque<int[]> deque = new ArrayDeque<>();
        deque.offer(new int[]{0,0});
        cost[0][0] = 0;
        while(!deque.isEmpty()){
            int[]curr = deque.poll();
            for(int i = 0;i<4;i++){
                int row = curr[0]+dx[i];
                int col = curr[1]+dy[i];
                int currCost = grid[curr[0]][curr[1]]!=i+1?1:0;
                int newCost = cost[curr[0]][curr[1]]+currCost;
                if(row>=0 && row<m && col>=0 && col<n && newCost < cost[row][col]){
                    cost[row][col] = newCost;
                    if(currCost == 1) deque.offerLast(new int[]{row,col});
                    else deque.offerFirst(new int[]{row,col});
                }
            }
        }

        return cost[m-1][n-1];
    }
}
public class MinCostToMakeValidPath {
    public static void main(String[] args) {
        SolutionMCVALP mc = new SolutionMCVALP();
        System.out.println(mc.minCost(new int[][]{{1,1,1,1},{2,2,2,2},{1,1,1,1},{2,2,2,2}}));
    }
}
