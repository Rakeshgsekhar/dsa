class SolutionWSBT {
    int id = 0;
//    StringBuilder sb = new StringBuilder();
    public boolean exist(char[][] board, String word) {
        int n = board.length;
        int m = board[0].length;
        StringBuilder sb  = new StringBuilder();
        boolean[][] visited = new boolean[n][m];
        for(int i = 0;i<n;i++){
            for(int j = 0;j<m;j++){
                if(board[i][j] == word.charAt(0)){
                    return compute(i,j,n,m,word,board,visited,0);
                }
            }
        }
        return false;
    }


    private boolean compute(int row,int col,int n,int m,String word,char[][] board,boolean[][]visited,int index){
        if(index == word.length()) return true;
        if(row<0 || col<0 || row>=n || col>=m || visited[row][col] || board[row][col] != word.charAt(index)) return false;
        visited[row][col] = true;
        boolean res = compute(row+1,col,n,m,word,board,visited,index+1) || compute(row-1,col,n,m,word,board,visited,index+1)
                ||compute(row,col+1,n,m,word,board,visited,index+1)||compute(row,col-1,n,m,word,board,visited,index+1);

        visited[row][col] = false;

        return res;
    }
}
public class WordSearch {
    public static void main(String[] args) {
        SolutionWSBT ws = new SolutionWSBT();
        System.out.println(ws.exist(new char[][]{{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}},"ABCCED"));
    }
}
