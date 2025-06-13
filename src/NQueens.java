import java.util.ArrayList;
import java.util.List;

class SolutionNQ {
   /* int res = 0;
    public int totalNQueens(int n) {
        int[][] board = new int[n][n];
//        int res = 0;
        List<Integer> result = new ArrayList<>();
        int[] cols = new int[n];
        int[] rightDiagonal  = new int[n*2];
        int[] leftDiagonal = new int[n*2];
        countSolutions(board,0,n);
        return res;
//        return -1;
    }

    private void countSolutions(int[][]board,int row,int n){
        if(row == n){
            res++;
            return;
        }

        for(int col = 0;col<n;col++) {
            if(isSafe(board,row,col,n)){
                board[row][col] = 1;
                countSolutions(board,row+1,n);
                board[row][col] = 0;
            }
        }
    }

    private boolean isSafe(int[][] board,int row,int col,int n){
        for(int i = 0;i<row;i++){
            if(board[i][col] == 1) return false;
        }
        for(int i = row-1,j=col-1;i>=0 && j>=0;i--,j--){
            if(board[i][j] == 1) return false;
        }

        for(int i = row-1,j=col+1;i>=0 && j<n;i--,j++){
            if(board[i][j] == 1) return false;
        }


        return true;
    }*/
    int res = 0;
    public int totalNQueens(int n) {
       int[][] board = new int[n][n];
       List<Integer> result = new ArrayList<>();
       int[] cols = new int[n];
       int[] rightDiagonal  = new int[n*2];
       int[] leftDiagonal = new int[n*2];
       canPlace(0,n,result,cols,rightDiagonal,leftDiagonal);
       return res;
   }
    private void canPlace(int row,int n,List<Integer>curr,int[]cols,int[] rightDiagonal,int[] leftDiagonal){
        if(row == n) {
            res++;
            return;
        }
        for(int col = 0;col<n;col++) {
            if (cols[col] == 1 || rightDiagonal[row+col] == 1 || leftDiagonal[row - col + n - 1] == 1) continue;
            cols[col] = 1;
            rightDiagonal[row+col] = 1;
            leftDiagonal[row-col+n-1] = 1;
            curr.add(col+1);
            canPlace(row+1,n,curr,cols,rightDiagonal,leftDiagonal);
            curr.remove(curr.size()-1);
            cols[col] = 0;
            rightDiagonal[row+col] = 0;
            leftDiagonal[row-col+n-1] = 0;

        }
    }
}
public class NQueens {
    public static void main(String[] args) {
        SolutionNQ nq = new SolutionNQ();
        System.out.println(nq.totalNQueens(4));
    }
}
