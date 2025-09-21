import java.util.ArrayList;
import java.util.List;
import java.util.Map;

class SolutionLOVSD {
    public int lenOfVDiagonal(int[][] grid) {
        int[] maxLen = new int[1];
        int n = grid.length;
        int m = grid[0].length;
        int[] dx = new int[]{-1,1,1,-1};
        int[] dy = new int[]{-1,-1,1,1};
        int[][] dir = new int[][]{{-1,1},{1,1},{1,-1},{-1,-1}};
        List<int[]> ones = new ArrayList<>();
        for(int i = 0;i<n;i++){
            for(int j = 0;j<m;j++){
                if(grid[i][j] == 1){
                   for(int d = 0;d<4;d++){
                       maxLen[0] = Math.max(maxLen[0],findMaxDiagonal(grid,i,j,d,dir,2,false));
                   }
                }
            }
        }
        return maxLen[0];
    }

    private int findMaxDiagonal(int[][] grid,int row, int col, int d,int[][] dir,int target, boolean isTurned){
        /*if(row<0 || col <0 || row>=grid.length || col >= grid[0].length) {
            maxLen[0] = Math.max(maxLen[0],currlen);
            return ;
        }
        if(grid[row][col] == -1) return;
        if(!start && zero && grid[row][col] != 0){
            maxLen[0] = Math.max(maxLen[0],currlen);
            return ;
        }

        if(!start && !zero && grid[row][col] != 2){
            maxLen[0] = Math.max(maxLen[0],currlen);
            return ;
        }
        grid[row][col] = -1;
        for(int i = 0;i<4;i++){
            findMaxDiagonal(grid,row+dx[i],col+dy[i],dx,dy,currlen+1,!zero,maxLen,false);
        }*/
        int nrow = row + dir[d][0];
        int ncol = col + dir[d][1];
        if(nrow<0 || ncol <0 || nrow>=grid.length || ncol >= grid[0].length || grid[nrow][ncol] != target) {
            return 1;
        }
        int curr = 1+ findMaxDiagonal(grid,nrow,ncol,d,dir,target == 2?0:2,isTurned);
        int turn = 0;
        if(!isTurned){
            turn = 1 + findMaxDiagonal(grid,nrow,ncol,(d+1)%4,dir,target == 2?0:2,true);
        }
        return Math.max(curr,turn);
    }
}
public class LengthOfVShapedDSegment {
    public static void main(String[] args) {
        SolutionLOVSD st = new SolutionLOVSD();
        System.out.println(st.lenOfVDiagonal(new int[][]{{2,2,2,2,2},{2,0,2,2,0},{2,0,1,1,0},{1,0,2,2,2},{2,0,0,2,2}}));
    }
}
