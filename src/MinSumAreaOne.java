
class SolutionMAO {
//    int[][] grid;
//    int n, m;
   /* public int minimumSum(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int ans = Integer.MAX_VALUE/3;

        // horizontal slice
        for(int i = 0;i<n-1;i++) {
            ans = Math.min(ans, Math.min(getRectArea(0,0,i,m-1,grid) + minArea(i+1,0, n-1, m-1,grid),
                    minArea(0,0,i,m-1,grid) + getRectArea(i+1,0, n-1, m-1,grid)));
        }

        // vertical slice
        for(int j = 0;j<m-1;j++) {
            ans = Math.min(ans, Math.min(getRectArea(0, 0, n-1, j,grid) + minArea(0, j+1, n-1, m-1,grid),
                    minArea(0, 0, n-1, j,grid) + getRectArea(0, j+1, n-1, m-1,grid)));
        }

        return ans;
    }

    public int minArea(int row1, int col1, int row2, int col2,int[][] grid) {
        // horizontal slice
        int area = Integer.MAX_VALUE/2;
        for(int row = row1;row<row2;row++) {
            area = Math.min(area, getRectArea(row1,col1,row,col2,grid) + getRectArea(row+1,col1,row2,col2,grid));
        }

        // vertical slice
        for(int col = col1;col<col2;col++) {
            area = Math.min(area, getRectArea(row1,col1,row2,col,grid) + getRectArea(row1,col+1,row2,col2,grid));
        }

        return area;
    }

    public int getRectArea(int row1, int col1, int row2, int col2,int[][] grid) {
        int minHeight = col2, maxHeight = col1, minWidth = row2, maxWidth = row1;
        boolean has = false;

        for(int i = row1;i<=row2;i++) {
            for(int j = col1;j<=col2;j++) {
                if (grid[i][j] == 0) continue;
                has = true;
                minHeight = Math.min(minHeight, j);
                maxHeight = Math.max(maxHeight, j);

                minWidth = Math.min(minWidth, i);
                maxWidth = Math.max(maxWidth, i);
            }
        }

        return !has ? Integer.MAX_VALUE/4 : (maxHeight - minHeight + 1)*(maxWidth - minWidth + 1);
    }*/

    public int minimumSum(int[][] grid) {
        int area = 0;
        int n = grid.length;
        int m = grid[0].length;
        /**
         * 6 Cases
         * 1. one top plus bottom left and right : 3 rect
         * 2. one bottom plus top left and right : 3 rect
         * 3. one left plus right top and bottom : 3 rect
         * 4. one right plus left top and bottom : 3 rect
         * 5. all vertical cut top middle bottom : 3 rect
         * 6. all horizontal cut left mid right  : 3 rect
         */

        /**
         * Case 1
         */

        for(int i = 0;i<n;i++){
            int top = getArea(0,i,0,m-1,grid);
            for(int j = 0; j<m ; j++){
                area = Math.min(area, top+ getArea(i+1,n-1,0,j,grid)+getArea(i+1,n-1,j+1,m-1,grid));
            }
        }

        /**
         * Case 2
         */

        for(int i = 0;i<n;i++){
            int bottom = getArea(i,n-1,0,m-1,grid);
            for(int j = 0;j<m;j++){
                area = Math.min(area,bottom+getArea(0,i,0,j,grid)+getArea(0,i,j+1,m-1,grid));
            }
        }

        /***
         * Case 3
         */

        for(int j = 0;j<m;j++){
            int left = getArea(0,n-1,0,j,grid);
            for(int i = 0;i<n;i++){
                area = Math.min(area,left+getArea(0,i,j+1,m-1,grid)+getArea(i+1,n-1,j+1,m-1,grid));
            }
        }

        /**
         * Case 4
         */
        for(int j = 0;j<m;j++){
            int right = getArea(0,n-1,j,m-1,grid);
            for(int i = 0;i<n;i++){
                area = Math.min(area,right+getArea(0,i,0,j-1,grid)+getArea(i+1,n-1,0,j-1,grid));
            }
        }


        /**
         * Case 5
         */

        for(int i = 0;i<n;i++){
            for(int i2 = i+1;i2<n;i2++){
                area = Math.min(area,getArea(0,i,0,m-1,grid)+getArea(i+1,i2,0,m-1,grid)+getArea(i2+1,n-1,0,m-1,grid));
            }
        }

        /**
         * Case 6
         */
        for(int j = 0;j<m;j++){
            for(int j2 = j+1;j2<m;j2++){
                area = Math.min(area,getArea(0,n-1,0,j,grid)+getArea(0,n-1,j+1,j2,grid)+getArea(0,n-1,j2+1,m-1,grid));
            }
        }

        return area;

    }

    private int getArea(int minRow,int maxRow,int minCol,int maxCol,int[][] grid){
        int area = 0;
        int min_row = Integer.MAX_VALUE;
        int min_col = Integer.MAX_VALUE;
        int max_row = 0;
        int max_col = 0;

        for(int i = minRow;i<=maxRow;i++){
            for(int j = minCol;j<=maxCol;j++){
                if(grid[i][j] == 1){
                    min_row = Math.min(min_row,i);
                    min_col = Math.min(min_col,j);
                    max_row = Math.max(max_row,i);
                    max_col = Math.max(max_col,j);
                }
            }
        }
        return min_row == Integer.MAX_VALUE ? 0:(max_row-min_row+1)*(max_col-min_col+1);
    }


}
public class MinSumAreaOne {

    public static void main(String[] args) {

    }
}
