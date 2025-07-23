import java.util.LinkedList;
import java.util.Queue;

class SolutionZEROONE {
    class ZeroOne{
        int row;
        int col;
        int steps;

        public ZeroOne(int row, int col, int steps) {
            this.row = row;
            this.col = col;
            this.steps = steps;
        }
    }
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        if(grid[0][0] !=0 || grid[n-1][m-1]!=0) return -1;

        int[]dx = {-1,-1,-1,0,1,1,1,0};
        int[]dy = {-1,0,1,1,1,0,-1,-1};
        Queue<ZeroOne> queue = new LinkedList<>();
        boolean[][]visited = new boolean[n][m];
        queue.offer(new ZeroOne(0,0,1));
        visited[0][0] = true;
        while(!queue.isEmpty()){
            ZeroOne node = queue.poll();
            int row = node.row;
            int col = node.col;
            int steps = node.steps;
            if(row == n-1 && col == m-1){
                return steps;
            }
            for(int i = 0;i<8;i++){
                int nRow = row+dx[i];
                int nCol = col+dy[i];
                if(nRow>=0 && nRow<n && nCol>=0 && nCol<m && !visited[nRow][nCol] && grid[nRow][nCol]==0){
                    queue.offer(new ZeroOne(nRow,nCol,steps+1));
                    visited[nRow][nCol] = true;
                }
            }
        }
        return -1;
    }
}
public class ZeroOneBFS {
    public static void main(String[] args) {

    }
}
