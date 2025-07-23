import java.util.LinkedList;
import java.util.Queue;

class SolutionSHB {
    public int shortestBridge(int[][] grid) {
        Queue<int[]> queue = new LinkedList<>();
        boolean flag = false;
        for(int i = 0;i<grid.length;i++){
            for(int j = 0;j<grid[0].length;j++){
                if(grid[i][j] == 1){
                    findIslandDFS(grid,i,j,queue);
                    flag=true;
                    break;
                }
            }
            if(flag) break;
        }
        return shortestBridgeBFS(grid,queue);
    }

    private void findIslandDFS(int[][]grid, int i, int j, Queue<int[]> queue){
        if(i<0||i>= grid.length||j<0||j>=grid[0].length||grid[i][j]==-1 || grid[i][j]==0) return;
        grid[i][j] = -1;
        queue.offer(new int[]{i,j});
        findIslandDFS(grid,i+1,j,queue);
        findIslandDFS(grid,i,j+1,queue);
        findIslandDFS(grid,i-1,j,queue);
        findIslandDFS(grid,i,j-1,queue);
        return;
    }

    private int shortestBridgeBFS(int[][]grid,Queue<int[]> queue){
        int[]dx = new int[]{1,0,-1,0};
        int[]dy = new int[]{0,1,0,-1};
        int steps = 0;
        while (!queue.isEmpty()){
            int size = queue.size();//multisource BFS
            for(int c = 0;c<size;c++){
                int[]shore = queue.poll();
                for(int i = 0;i<4;i++){
                    int row = shore[0]+dx[i];
                    int col = shore[1]+dy[i];
                    if(row>=grid.length||row<0||col<0||col>=grid[0].length||grid[row][col] == -1) continue;
                    if(grid[row][col] == 1) return steps;
                    else {
                        grid[row][col] = -1;
                        queue.offer(new int[]{row,col});
                    }
                }
            }
            steps++;
        }
        return -1;
    }
}
public class ShortestBridge {
    public static void main(String[] args) {
        SolutionSHB shb = new SolutionSHB();

        System.out.println(shb.shortestBridge(new int[][]{{0,1},{1,0}}));
        System.out.println(shb.shortestBridge(new int[][]{{1,1,1,1,1},{1,0,0,0,1},{1,0,1,0,1},{1,0,0,0,1},{1,1,1,1,1}}));
    }
}
