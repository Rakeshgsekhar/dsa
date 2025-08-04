import java.util.LinkedList;
import java.util.Queue;

class SolutionMLIP {
    public int longestIncreasingPath(int[][] matrix) {

        /*int path = 1;
        for(int i =0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                path = Math.max(path,LIPBFS(matrix,i,j));
            }
        }
        return path;*/


        //Topo Sort
        int m = matrix.length;
        int n = matrix[0].length;
        int[]dx = new int[]{1,0,-1,0};
        int[]dy = new int[]{0,1,0,-1};

        int[][] outDegree = new int[m][n];

        for(int i = 0;i<m;i++){
            for(int j = 0;j<n;j++){
                for(int d = 0;d<4;d++){
                    int ni = i+dx[d];
                    int nj = j+dy[d];
                    if(nj<0 || ni<0 || ni>=m || nj>=n || matrix[ni][nj]<=matrix[i][j]) continue;
                    outDegree[i][j]++;
                }
            }
        }

        Queue<int[]> queue = new LinkedList<>();
        for(int i = 0;i<m;i++) {
            for (int j = 0; j < n; j++) {
                if(outDegree[i][j] == 0){
                    queue.add(new int[]{i,j});
                }
            }
        }

        //SOrting
        int maxPath = 0;
        while (!queue.isEmpty()){
            int size = queue.size();
            maxPath++;
            while(size-->0){
                int[] rc = queue.poll();
                for(int i = 0;i<4;i++){
                    int nr = rc[0]+dx[i];
                    int nc = rc[1]+dy[i];

                    if(nr<0 || nc<0 || nr>=m || nc>=n) continue;
                    if(matrix[nr][nc] <= matrix[rc[0]][rc[1]]) continue;
                    if(--outDegree[nr][nc] == 0) queue.offer(new int[]{nr,nc});
                }
            }
        }
        return maxPath;
    }

    private int LIPBFS(int[][]matrix,int r,int c){
        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        int path = 0;
        int m = matrix.length;
        int n = matrix[0].length;
        Queue<int[]>queue = new LinkedList<>();
        queue.offer(new int[]{r,c});
        while(!queue.isEmpty()){
            int size = queue.size();
            path++;
            for(int i=0;i<size;i++){
                int[]rc = queue.poll();
                for(int [] dir:dirs){
                    int nr = rc[0]+dir[0];
                    int nc = rc[1]+dir[1];
                    if(nr<0 || nc<0 || nr>=m || nc >=n) continue;
                    if(matrix[nr][nc]>matrix[r][c]) queue.offer(new int[]{nr,nc});
                }
            }
        }
        return path;
    }
}
public class MatrixLongestIncrerasingPath {
}
