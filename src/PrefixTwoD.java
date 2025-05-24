
class SolutionPTS {
    int[][]nums;
    int [][] sumGrid;
    public int prefixSum(int[][] nums){
        this.nums = nums;
        int rows = nums.length;
        int cols = nums[0].length;
        sumGrid = new int[rows][cols];
        sumGrid[0][0] = nums[0][0];
        for(int i = 1;i<rows;i++){
            sumGrid[i][0] = sumGrid[i-1][0]+nums[i][0];
        }
        for(int i = 1;i<cols;i++){
            sumGrid[0][i] = sumGrid[0][i-1]+nums[0][i];
        }

        for(int i = 1;i<rows;i++){
            for(int j = 1;j<cols;j++){
                sumGrid[i][j] = sumGrid[i-1][j]+sumGrid[i][j-1]-sumGrid[i-1][j-1]+nums[i][j];
            }
        }

        for(int i = 0;i<rows;i++){
            for(int j = 0;j<cols;j++){
                System.out.print(nums[i][j]);
                System.out.print(" ");
            }
            System.out.println();
        }

        int totalSum = 0;
        System.out.println();
        for(int i = 0;i<rows;i++){
            for(int j = 0;j<cols;j++){
                totalSum+=sumGrid[i][j];
                System.out.print(sumGrid[i][j]);
                System.out.print(" ");
            }
            System.out.println();
        }

//        System.out.println(totalSum);
       /* int totalSumTill = 0;
        System.out.println();
        for(int i = 0;i<=2;i++){
            for(int j = 0;j<=3;j++){
                totalSumTill+=sumGrid[i][j];
                System.out.print(sumGrid[i][j]);
                System.out.print(" ");
            }
            System.out.println();
        }

        System.out.println(totalSumTill);

        int remainingSumTill = 0;
        System.out.println();
        for(int j = 0;j<cols;j++){
            remainingSumTill+=sumGrid[2][j];
        }

        for(int i = 0;i<rows;i++){
            remainingSumTill+=sumGrid[i][4];
        }

        System.out.println(remainingSumTill);
*/

        return 0;
    }

//    public int getData(int row,int col){
//        System.out.print("matrix : ");
//        System.out.println(matrix[row][col]);
//        System.out.print("Sum : ");
//        System.out.println(sumGrid[row][col]);
//        return 0;
//    }
    public int sumRegion(int row1, int col1, int row2, int col2) {
        if((row1 == 0 && col1 == 0)){
            return sumGrid[row2][col2];
        }
        if(row1 == row2 && col1 == col2){
            return nums[row1][col1]; //sumGrid[row2][col2]

        }
        if(row1 == row2 && row1 == 0){
            return sumGrid[row2][col2] - sumGrid[row1][col1-1];
        }
        if(col1 == col2 && col1==0){
            return sumGrid[row2][col2] - sumGrid[row1-1][col1];
        }

        System.out.println(row1+"+"+col1+":"+row2+"+"+col2);
        return sumGrid[row2][col2]-sumGrid[row2][col1-1]-sumGrid[row1-1][col2]+sumGrid[row1-1][col1-1];
    }
}
public class PrefixTwoD {
    public static void main(String[] args) {
        int[][] matrixs = new int[][]{{8,-4,5},{-1,4,4},{-2,3,1},{-4,4,3}};

        SolutionPTS pts = new SolutionPTS();
        pts.prefixSum(matrixs);
        System.out.println(pts.sumRegion(0,1,0,2));
        System.out.println(pts.sumRegion(1,1,1,2));
        System.out.println(pts.sumRegion(0,1,0,2));
    }
}
