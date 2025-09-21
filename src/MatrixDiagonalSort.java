import java.util.*;

class SolutionMDSORT {
    /**
     * bottom left including middle -> non-increasing
     * top right -> non - decreasing
     * @param grid
     * @return
     */
    public int[][] sortMatrix(int[][] grid) {
        int n = grid.length;
        int[][] sorted = new int[n][n];
        //bottom left including left;
        for(int diagonal = 1;diagonal<n;diagonal++){
            int i = 0;
            int j = diagonal;
            PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->a-b);
            int rs = i,rc = j;
            while(i<n && j<n){
                pq.offer(grid[i][j]);
                i++;
                j++;
            }

            while (rs<n && rc < n){
                grid[rs][rc] = pq.poll();
                rs++;
                rc++;
            }
        }
        //top right
        for(int diagonal = 0;diagonal<n;diagonal++){
            int i = diagonal;
            int j = 0;
            PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->b-a);
            int rs = i,rc = j;
            while(i<n && j<n){
                pq.offer(grid[i][j]);
                i++;
                j++;
            }

            while (rs<n && rc < n){
                grid[rs][rc] = pq.poll();
                rs++;
                rc++;
            }
        }
        return grid;
    }
    private void sort(int[][] sorted, int[][] grid, int rs, int cs, int rn, int cn, boolean dec){
        if(rs == grid.length-1 || cs == grid.length-1){
            sorted[rs][cs] = grid[rs][cs];
            return;
        }
//        int i = rs;
        int n = rn-rs+1;
        int temp = cs;
        List<Integer> listToSort = new ArrayList<>();
        for(int i = rs;i<rn;i++){
            listToSort.add(grid[i][cs]);
            cs++;
        }

        if(dec) listToSort.sort((a,b)->b-a);
        else listToSort.sort((a,b)->a-b);

        int idx = 0;
        for(int i = rs;i<rn;i++){
           sorted[i][temp++] = listToSort.get(idx++);
        }
    }
}
public class MatrixDiagonalSort {
    public static void main(String[] args) {
        SolutionMDSORT msd = new SolutionMDSORT();
        msd.sortMatrix(new int[][]{{1,7,3},{9,8,2},{4,5,6}});
    }
}
