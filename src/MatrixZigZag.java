class SolutionMZ {
    public int[] findDiagonalOrder(int[][] mat) {
        int n = mat[0].length;
        int m = mat.length;
        int[] res = new int[m*n];
        int el = 0;
        int totalEl = n*m;
        int row = 0;
        int col = 0;
        boolean rowInc = true;
        while(el<totalEl){
            res [el++] = mat[row][col];
            if(rowInc){
                if(row>0 && col<n-1){
                    row--;
                    col++;
                }else{
                    rowInc=false;
                    if(col == n-1){
                        row ++;
                    }else{
                        col++;
                    }
                }
            }else{
                if(row<m-1 && col>0){
                    row++;
                    col--;
                }else{
                    rowInc = true;
                    if(row == m-1){
                        col++;
                    }else{
                        row++;
                    }
                }
            }

        }
        return res;
    }
}

class SolutionMZZ2 {
    public int[] findDiagonalOrder(int[][] mat) {
        int[] res = new int[mat.length * mat[0].length];
        int index = 0;

        traverseUp(mat, 0, 0, res, index);
        return res;
    }

    public static void traverseUp(int[][] mat, int r, int c, int[] res, int index){
        if (r < 0 || r >= mat.length || c < 0 || c >= mat[0].length) {
            return;
        }
        res[index] = mat[r][c];
        index += 1;

        if(r > 0 && c < mat[0].length - 1) {
            traverseUp(mat, r-1, c+1, res, index);
        } else if (r == 0 && c < mat[0].length - 1) {
            traverseDown(mat, r, c+ 1, res, index);
        } else if (c == mat[0].length - 1) {
            traverseDown(mat, r+1, c, res, index);
        }
    }

    public static void traverseDown(int[][] mat, int r, int c, int[] res, int index){
        if (r < 0 || r >= mat.length || c < 0 || c >= mat[0].length) {
            return;
        }

        res[index] = mat[r][c];
        index += 1;

        if(c > 0 && r < mat.length - 1) {
            traverseDown(mat, r+1, c-1, res, index);
        } else if (c == 0 && r < mat.length - 1) {
            traverseUp(mat, r+1, c, res, index);
        } else if (r == mat.length - 1) {
            traverseUp(mat, r, c+1, res, index);
        }
    }
}


public class MatrixZigZag {
    public static void main(String[] args) {
        int[][] mat = new int[][]{{1,2,3},{4,5,6},{7,8,9}};
        SolutionMZ mz = new SolutionMZ();
        int[] res = mz.findDiagonalOrder(mat);

        System.out.print("[");
        for(int i = 0;i<res.length;i++){
            System.out.print(res[i]+",");
        }
        System.out.print("]");

    }
}
