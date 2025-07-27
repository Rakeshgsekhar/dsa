import java.util.LinkedList;
import java.util.Queue;

class SolutionMHP {
    public int[][] highestPeak(int[][] isWater) {
        Queue<int[]>queue = new LinkedList<>();
        int m = isWater.length;
        int n = isWater[0].length;
        for(int i = 0;i<m;i++){
            for(int j=0;j<n;j++){
                if(isWater[i][j] == 1){
                    isWater[i][j] = 0;
                    queue.add(new int[]{i,j});
                }else{
                    isWater[i][j] = -1;
                }
            }
        }
        int[]dx = {1,0,-1,0};
        int[]dy ={0,1,0,-1};
        while (!queue.isEmpty()){
            int[]rc = queue.poll();
            for(int i=0;i<4;i++){
                int nr = rc[0]+dx[i];
                int nc = rc[1]+dy[i];
                if(nr>=0 && nc >=0 && nr<m && nc<n && isWater[nr][nc] == -1){
                    isWater[nr][nc] = isWater[rc[0]][rc[1]]+1;
                    queue.offer(new int[]{nr,nc});
                }
            }
        }
        return isWater;
    }
}
public class MapHeighestPeek {
    public static void main(String[] args) {
        SolutionMHP mp = new SolutionMHP();
        mp.highestPeak(new int[][]{{0,1},{0,0}});
    }
}
