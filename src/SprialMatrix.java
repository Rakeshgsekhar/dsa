import java.util.ArrayList;
import java.util.List;

class SolutionSPM {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        int m = matrix.length;
        int n = matrix[0].length;
        int totalNum = m*n;
        int el = 0;
        int row = 0,rowUpLimit = 0,rowDownLimit = m;
        int col = 0,colUpLimit = 0,colDownLimit = n;
        while(el<totalNum){
            while(col<colDownLimit){
                result.add(matrix[row][col++]);
                el++;
            }
            if(el>=totalNum) break;
            col = colDownLimit-1;
            row++;
            while(row<rowDownLimit){
                result.add(matrix[row++][col]);
                el++;
            }
            if(el>=totalNum) break;
            row = rowDownLimit-1;
            rowUpLimit++;
            col--;
            while(col>=colUpLimit){
                result.add(matrix[row][col--]);
                el++;
            }
            if(el>=totalNum) break;
            col = colUpLimit;
            colDownLimit--;
            row--;
            while(row>=rowUpLimit){
                result.add(matrix[row--][col]);
                el++;
            }
            row = rowUpLimit;
            col = colUpLimit+1;
            colUpLimit++;
            rowDownLimit--;
        }

        return result;
    }
}
public class SprialMatrix {
    public static void main(String[] args) {
        SolutionSPM smp = new SolutionSPM();
        int[][] mat = new int[][]{{1,2,3,4},{5,6,7,8},{9,10,11,12}};
        int[][] mat1 = new int[][]{{1}};
        int[][] mat2 = new int[10][10];
        int[][] mat3 = new int[][]{{1,2,3},{4,5,6},{7,8,9}};
        int k = 1;
        for(int i = 0;i<10;i++){
            for(int j=0;j<10;j++){
                mat2[i][j] = k++;
            }
        }
        /*
        System.out.print("[");
        for(int i = 0;i<10;i++){
            System.out.print("[");
            for(int j=0;j<10;j++){
                System.out.print(mat2[i][j]+",");
            }
            System.out.print("]");
        }
        System.out.println("]");
*/
        int[]  cmp = new int[]{1,2,3,4,5,6,7,8,9,10,20,30,40,50,60,70,80,90,100,99,98,97,96,95,94,93,92,91,81,71,61,51,41,31,21,11,12,13,14,15,16,17,18,19,29,39,49,59,69,79,89,88,87,86,85,84,83,82,72,62,52,42,32,22,23,24,25,26,27,28,38,48,58,68,78,77,76,75,74,73,63,53,43,33,34,35,36,37,47,57,67,66,65,64,54,44,45,46,56,55};

        System.out.println(smp.spiralOrder(mat));
        System.out.println(smp.spiralOrder(mat1));
        List<Integer> res = smp.spiralOrder(mat2);
        //System.out.println(smp.spiralOrder(mat2));
        if(cmp.length == res.size())
            System.out.println("sizeMatched");
        for(int i = 0;i<cmp.length;i++){
            if(cmp[i] != res.get(i)){
                System.out.println("value unmatched");
            }
        }
        System.out.println(smp.spiralOrder(mat3));

    }
}
