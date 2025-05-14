class SolutionSPMC {
    public int[][] generateMatrix(int n) {
        int[][] matrix  = new int[n][n];
        int k = 1;
        int m = n;
        int totalNum = m*n;
        int el = 0;
        int row = 0,rowUpLimit = 0,rowDownLimit = m;
        int col = 0,colUpLimit = 0,colDownLimit = n;
        while(el<totalNum){
            while(col<colDownLimit){
              //  result.add(matrix[row][col++]);
                matrix[row][col++] = k++;
                el++;
            }
            if(el>=totalNum) break;
            col = colDownLimit-1;
            row++;
            while(row<rowDownLimit){
              //  result.add(matrix[row++][col]);
                matrix[row++][col] = k++;
                el++;
            }
            if(el>=totalNum) break;
            row = rowDownLimit-1;
            rowUpLimit++;
            col--;
            while(col>=colUpLimit){
             //   result.add(matrix[row][col--]);
                matrix[row][col--] = k++;
                el++;
            }
            if(el>=totalNum) break;
            col = colUpLimit;
            colDownLimit--;
            row--;
            while(row>=rowUpLimit){
              //  result.add(matrix[row--][col]);
                matrix[row--][col]=k++;
                el++;
            }
            row = rowUpLimit;
            col = colUpLimit+1;
            colUpLimit++;
            rowDownLimit--;
        }

        return matrix;
    }
}
public class GenerateSpiralMatrix {
    public static void main(String[] args) {
        SolutionSPMC spmc = new SolutionSPMC();
        int[][] res = spmc.generateMatrix(10);
        System.out.print("[");
        for(int i = 0;i<10;i++){
            System.out.print("[");
            for(int j = 0;j<10;j++){
                System.out.print(res[i][j]+",");
            }
            System.out.print("]");
        }
        System.out.print("]");
    }
}
