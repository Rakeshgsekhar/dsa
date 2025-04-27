import java.util.LinkedList;
import java.util.Queue;

public class NearestEntrance {
    public int nearestExit(char[][] maze, int[] entrance) {
        int m = maze.length;
        int n = maze[0].length;

        int[][] directions = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(entrance);
        maze[entrance[0]][entrance[1]] = '+'; // no revisiting

        int steps = 0;
        int x,y;

        while(!queue.isEmpty()){
            steps++;
            int s = queue.size();
            for(int i = 0;i<s;i++){
                int[] current = queue.poll();
                for(int[] direction : directions){
                    x = current[0]+direction[0];
                    y = current[1]+direction[1];

                    if(x< 0 || x>=m || y<0 || y>=n) continue; //reached exit

                    if(maze[x][y] == '+') continue; //wall

                    if(x== 0 || x==m-1 || y==0 || y==n-1) return steps;

                    maze[x][y] = '+';
                    queue.offer(new int[]{x,y});
                }
            }
        }
        return -1;

    }
}
