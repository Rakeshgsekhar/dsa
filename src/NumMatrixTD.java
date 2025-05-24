class NumMatrix {
    int[][] sumGrid;
    int[][] nums;
    public NumMatrix(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        sumGrid = new int[rows][cols];
        nums = matrix;
        for(int i = 1;i<rows;i++){
            sumGrid[i][0] = sumGrid[i-1][0]+matrix[i][0];
        }
        for(int i = 1;i<cols;i++){
            sumGrid[0][i] = sumGrid[0][i-1]+matrix[0][i];
        }

        for(int i = 1;i<rows;i++){
            for(int j = 1;j<cols;j++){
                sumGrid[i][j] = sumGrid[i-1][j]+sumGrid[i][j-1]-sumGrid[i-1][j-1]+matrix[i][j];
            }
        }

    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        if((row1 == 0 && col1 == 0)){
            return sumGrid[row2][col2];
        }
        if(row1 == row2 && col1 == col2){
            return nums[row1][col1]; //sumGrid[row2][col2]

        }
        if(row1 == row2 ){
            return sumGrid[row2][col2] - sumGrid[row1][col1-1];
        }
        if(col1 == col2){
            return sumGrid[row2][col2] - sumGrid[row1-1][col1];
        }


        return sumGrid[row2][col2]-sumGrid[row2][col1-1]-sumGrid[row1-1][col2]+sumGrid[row1-1][col1-1];
    }
}
public class NumMatrixTD {
    public static void main(String[] args) {
        int[][] matrixs = new int[][]{{8,-4,5},{-1,4,4},{-2,3,1},{-4,4,3}};

        NumMatrix pts = new NumMatrix(matrixs);
        System.out.println(pts.sumRegion(0,1,0,2));
        System.out.println(pts.sumRegion(1,1,1,2));
        System.out.println(pts.sumRegion(0,1,0,2));

    }
}
