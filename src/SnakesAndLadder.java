import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class SolutionSANDL {
    public int snakesAndLadders(int[][] board) {
        int n = board.length;
        int[]minRolls = new int[n*n+1];
        Arrays.fill(minRolls,-1);
        Queue<Integer>queue = new LinkedList<>();
        queue.offer(1);
        minRolls[1] = 0;
        while(!queue.isEmpty()){
            int curr = queue.poll();
            for(int i=1;i<=6&&curr+i<=n*n;i++){
                int sq = curr+i;
                int row = (sq-1)/n;
                int col = (sq-1)%n;
                int v = board[n-1-row][(row % 2 == 1) ? (n - 1 - col) : col];
                int u = (v>0)?v:sq;
                if(u==n*n) return minRolls[curr]+1;
                if(minRolls[u] == -1){
                    minRolls[u] = minRolls[curr]+1;
                    queue.offer(u);
                }
            }
        }
        return -1;
    }
}
public class SnakesAndLadder {
}
