import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class Solution01M {
    public int[][] updateMatrix(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        //int[][]distance = new int[n][m];
       // for(int[] row:distance)
       // Arrays.fill(row,Integer.MAX_VALUE);

        Queue<int[]> queue = new LinkedList<>();
        for(int i = 0;i<n;i++){
            for(int j=0;j<m;j++){
                if(mat[i][j] == 0){
                    queue.offer(new int[]{i,j});
                }else{
                    mat[i][j] = Integer.MAX_VALUE;
                }
            }
        }

        int[]dx = {1,0,-1,0};
        int[]dy = {0,1,0,-1};
        while(!queue.isEmpty()){
            int[] rc = queue.poll();
            for(int i = 0;i<4;i++){
                int nr = rc[0]+dx[i];
                int nc = rc[1]+dy[i];
                if(nr>=0 && nr<n && nc>=0 && nc<m){
                    if(mat[nr][nc] > mat[rc[0]][rc[1]] + 1){
                        queue.offer(new int[]{nr,nc});
                        mat[nr][nc] = mat[rc[0]][rc[1]] + 1;
                    }
                }
            }
        }
        return mat;
    }

    private int findDisDFS(int[][]mat,int[][]dis,int row,int col,int steps){
        if(row<0 || col<0 || row>=mat.length || col>=mat[0].length) return Integer.MAX_VALUE;
        if(mat[row][col] == 0) return steps;
        else {
            int disTop = findDisDFS(mat,dis,row+1,col,steps+1);
            int disdown = findDisDFS(mat,dis,row-1,col,steps+1);
            int disleft = findDisDFS(mat,dis,row,col-1,steps+1);
            int disright = findDisDFS(mat,dis,row,col+1,steps+1);
            int distance = Math.min(disTop,Math.min(disdown,Math.min(disleft,disright)));
            return distance;
        }
    }
}
public class ZeroOneMatrix {
    public static void main(String[] args) {
        Solution01M st = new Solution01M();
        st.updateMatrix(new int[][]{{0,0,0},{0,1,0},{1,1,1}});
    }
}
