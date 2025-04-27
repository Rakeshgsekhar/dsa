import java.util.LinkedList;
import java.util.Queue;

public class RoatingOranges {
    public int orangesRotting(int[][] grid) {
        Queue<int[]> queue = new LinkedList<>();
        int startRow = 0,startCol = 0;
        int m = grid.length;
        int n = grid[0].length;
        int[][] visited = grid;
        int freshOranges = 0;


        for(int i = 0;i<m;i++){
            for(int j = 0;j<n;j++){
                if(grid[i][j] == 2){
                    queue.offer(new int[]{i,j});
                }else if(grid[i][j] == 1) freshOranges++;
            }
        }
        if(freshOranges == 0) return 0; // no fresh Oranges

        if(queue.isEmpty()) return -1; // no bad oranges

        int minutes = -1;
        int[][] directions = {{0,1},{1,0},{0,-1},{-1,0}};

        while(!queue.isEmpty()){
            int s = queue.size();
            while(s-->0){
                int[] current = queue.poll();
                int x = current[0];
                int y = current[1];

                for(int[] direction : directions){
                    int xx = x + direction[0];
                    int yy = y + direction[1];

                    if(xx>=0 && xx<m && yy>=0 & yy<n && visited[xx][yy] == 1){
                        visited[xx][yy] = 2;
                        freshOranges--;
                        queue.offer(new int[]{xx,yy});
                    }
                }
            }
            minutes++;

        }

        return freshOranges == 0 ? minutes:-1;

    }
}
