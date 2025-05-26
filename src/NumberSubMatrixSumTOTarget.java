import java.util.HashMap;
import java.util.Map;

class SolutionPMSC {
    public int numSubmatrixSumTarget(int[][] matrix, int target) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int count = 0;

        //Loop One
        /*for(int top = 0;top<rows;top++){
            int[] colSum = new int[cols];
            for(int bottom = top;bottom<rows;bottom++){
                //col compression
                for(int col = 0;col<cols;col++){
                    colSum[col] += matrix[bottom][col];
                }
                 count += countSubArrayWithTargetSum(colSum,target);
            }
        }*/

        //PreffixColSum
        for(int i= 0;i<rows;i++){
            for(int j = 1;j<cols;j++){
                matrix[i][j]+=matrix[i][j-1];
            }
        }

        HashMap<Integer,Integer> map = new HashMap<>();

        for(int left = 0;left<cols;left++){
            for(int right = left;right<cols;right++){
                map.clear();
                int sum = 0;
                for(int row = 0;row<rows;row++){
                    sum += matrix[row][right]-((left>0?matrix[row][left-1]:0));
                    if(sum==target){
                        count++;
                    }
                    count+=map.getOrDefault(sum-target,0);

                    map.put(sum,map.getOrDefault(sum,0)+1);
                }
            }
        }
        return count;

    }

    private int countSubArrayWithTargetSum(int[] nums,int target){
        Map<Integer,Integer> prefixCount = new HashMap<>();
        prefixCount.put(0,1);
        int prefixSum = 0,count = 0;
        for(int num:nums){
            prefixSum+=num;
            count+=prefixCount.getOrDefault(prefixSum-target,0);
            prefixCount.put(prefixSum,prefixCount.getOrDefault(prefixSum,0)+1);

        }
        return count;
    }
}
public class NumberSubMatrixSumTOTarget {
    public static void main(String[] args) {
        SolutionPMSC pm = new SolutionPMSC();
        int[][]matrix = new int[][]{{0,1,0},{1,1,1},{0,1,0}};
        System.out.println(pm.numSubmatrixSumTarget(matrix,0));
    }
}
