import java.util.LinkedList;
import java.util.Queue;

class SolutionSRGS {
    public void solve(char[][] board) {
        int n = board.length;
        int m = board[0].length;
        int[]dx = {1,0,-1,0};
        int[]dy = {0,1,0,-1};
        int sr = 0;
        int sc = 0;
        int er = n - 1;
        int ec = m - 1;

        for(int i = sc; i <= ec; i++){
            if(board[sr][i] == 'O'){
                filpDFS(board, dx, dy, sr, i);
            }
            if(board[er][i] == 'O'){
                filpDFS(board, dx, dy, er, i);
            }
        }

        for(int i = sr; i <= er; i++){
            if(board[i][sc] == 'O'){
                filpDFS(board, dx,dy, i, sc);
            }
            if(board[i][ec] == 'O'){
                filpDFS(board, dx, dy, i, ec);
            }
        }

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(board[i][j] == 'N'){
                    board[i][j] = 'O';
                } else if(board[i][j] == 'O'){
                    board[i][j] = 'X';
                }
            }
        }
    }

    private void filpDFS(char[][] board,int[]dx,int[]dy,int row,int col){
        board[row][col] = 'N';
        for(int i =0;i<4;i++){
            int nr = row+dx[i];
            int nc = col+dy[i];
            if(nr>=0 && nr<board.length&&nc>=0&&nc<board[0].length && board[nr][nc] == 'O'){
                filpDFS(board,dx,dy,nr,nc);
            }
        }
    }
}
public class SourroundedRegions {
}
