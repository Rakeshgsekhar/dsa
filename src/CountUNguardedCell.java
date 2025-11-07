class SolutionCUGC {
    public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
        /*
        mxn grid
        gards[][] and walls [][] ->postion of wall and guard
        cells [][]

        [G W 0 1 0 0]
        [1 G 1 1 W 0]
        [1 1 W G 1 1]
        [1 1 0 1 0 0]
        */
        int unGiardedCells = 0;
        int[][] cells = new int[m][n];
        for(int[] guard: guards){
            cells[guard[0]][guard[1]] = -1; // guard
        }

        for(int[] wall: walls){
            cells[wall[0]][wall[1]] = -1; // guard
        }


        for(int[] guard : guards){
            markGuardedCells(cells,guard[0]+1,guard[1],false,true,m,n);
            markGuardedCells(cells,guard[0]-1,guard[1],false,false,m,n);
            markGuardedCells(cells,guard[0],guard[1]+1,true,true,m,n);
            markGuardedCells(cells,guard[0],guard[1]-1,true,true,m,n);
        }

        for(int i = 0;i<m;i++){
            for(int j =0;j<n;j++){
                if(cells[i][j] ==0) unGiardedCells++;
            }
        }
        return unGiardedCells;
    }


    private void markGuardedCells(int[][] cells, int row, int col,boolean colChcek,boolean inc, int m, int n){
        if(row<0 || col<0 || row>=m || col>=n || cells[row][col] == -1) return;
        cells[row][col] = 1;
        if(colChcek) {
            if (inc)
                markGuardedCells(cells, row, col + 1, colChcek, inc, m, n);
            else markGuardedCells(cells, row, col - 1, colChcek, inc, m, n);
        }else{
            if (inc)
                markGuardedCells(cells, row+1, col, colChcek, inc, m, n);
            else markGuardedCells(cells, row-1, col, colChcek, inc, m, n);
        }
    }
}
public class CountUNguardedCell {
    public static void main(String[] args) {
        SolutionCUGC ugc  = new SolutionCUGC();

//        System.out.println(ugc.countUnguarded(4,6,new int[][]{{0,0},{1,1},{2,3}},new int[][]{{0,1},{2,2},{1,4}}));
        System.out.println(ugc.countUnguarded(2,7,new int[][]{{1,5},{1,1},{1,6},{0,2}},new int[][]{{0,6},{0,3},{0,5}}));
    }

}
