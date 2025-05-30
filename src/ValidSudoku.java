class SolutionVS {
    public boolean isValidSudoku(char[][] board) {
        for(int i = 0;i<9;i++){
            int[] row = new int[10];
            for(int j = 0;j<9;j++){
                if(board[i][j] != '.') {
                    int r = board[i][j] - '0';
                    if (r < 1) return false;
                    row[r]++;
                    if (row[r] >= 2) return false;
                }
            }
        }

        for(int i = 0;i<9;i++){
            int[] col = new int[10];
            for(int j = 0;j<9;j++){
                if(board[j][i] != '.' ) {
                    int c = board[j][i] - '0';
                    if ( c < 1) return false;
                    col[c]++;
                    if ( col[c] >= 2) return false;
                }
            }
        }

        int[][]box = new int[10][10];

        for(int i = 0;i<9;i++){
            for(int j = 0;j<9;j++){
                if(board[j][i] != '.' ) {
                    int c = board[j][i] - '0';
                    int index = (i/3)*3+(j/3);
                    if ( c < 1) return false;
                    box[index][c]++;
                    if ( box[index][c] >= 2) return false;
                }
            }
        }

        return true;
    }
}
public class ValidSudoku {
    public static void main(String[] args) {
        char[][] sudo = new char[][]{{'5','3','.','.','7','.','.','.','.'},{'6','.','.','1','9','5','.','.','.'},{'.','9','8','.','.','.','.','6','.'},{'8','.','.','.','6','.','.','.','3'},{'4','.','.','8','.','3','.','.','1'},{'7','.','.','.','2','.','.','.','6'},{'.','6','.','.','.','.','2','8','.'},{'.','.','.','4','1','9','.','.','5'},{'.','.','.','.','8','.','.','7','9'}};
        SolutionVS vs = new SolutionVS();
        System.out.println(vs.isValidSudoku(sudo));
    }
}
