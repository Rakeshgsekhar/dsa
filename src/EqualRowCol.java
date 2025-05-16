import java.util.HashMap;
import java.util.Map;

class SolutionERC {
    public int equalPairs(int[][] grid) {
       /* int n = grid.length;
        Map<Integer,Integer> mapper = new HashMap<>();
        int counter = 0;
        for(int i = 0;i<n;i++){
            int s = hashRowArray(grid[i]);
            mapper.put(s,mapper.getOrDefault(s,0)+1);
        }

        for(int i = 0;i<n;i++){
            int s = hashColArray(grid, i);
            counter+=mapper.getOrDefault(s,0);
        }

        return counter;*/

        /**
         int n = grid.length;
         String[] rows = new String[n];
         String[] cols = new String[n];

         for(int i = 0;i<n;i++){
         String s = "";
         for(int j = 0;j<n;j++){
         s+=grid[i][j];
         s+="-";
         }
         rows[i] = s;
         }

         for(int i = 0;i<n;i++){
         String s = "";
         for(int j = 0;j<n;j++){
         s+=grid[j][i];
         s+="-";
         }
         cols[i] = s;
         }


         Map<String,Integer> mapper = new HashMap<>();
         for(String s : rows){
         mapper.put(s,mapper.getOrDefault(s,0)+1);
         }
         int counter = 0;
         for(String s : cols){
         if(mapper.containsKey(s))
         counter+=mapper.get(s);
         //counter++;
         }

         return counter;

         */
        int counter = 0;

        int n = grid.length;
        for(int row = 0;row<n;row++){
            for(int col = 0;col<n;col++){
                if(grid[row][0] == grid[0][col]){
                    if(validate(grid,row,col)){
                        counter++;
                    }
                }
            }
        }
        return counter;
    }
    private boolean validate(int[][] grid,int row,int col){
        for(int i = 0;i<grid.length;i++){
            if(grid[row][i] != grid[i][col]){
                return false;
            }
        }
        return true;
    }
/*
    private int hashColArray(int[][] grid, int index) {
        int hashValue=0;
        for(int i=0;i< grid.length;i++){
            hashValue=hashValue*5+grid[i][index];
        }
        return hashValue;
    }

    private int hashRowArray(int[] array) {
        int hashValue = 0;
        for(int num : array){
            hashValue = hashValue*5+num;
        }
        return hashValue;
    }
*/
}

class SolutionSERC{
    public int equalPairs(int[][] grid) {
        int counter  = 0;
        Map<String,Integer> mapper = new HashMap<>();
        int n = grid.length;
        for(int i = 0;i<n;i++){
            String sRow = buildString(grid,i,true);
            mapper.put(sRow,mapper.getOrDefault(sRow,0)+1);
        }
        for(int i= 0;i<n;i++){
            String cRow = buildString(grid,i,false);
            counter += mapper.getOrDefault(cRow,0);
        }
        return counter;
    }

    private String buildString(int[][] grid,int rc, boolean isRow){
        StringBuilder sb = new StringBuilder();
        int n = grid.length;
        if(isRow){
            for(int i = 0;i<n;i++){
                sb.append(grid[rc][i]);
            }
        }else{
            for(int i = 0;i<n;i++){
                sb.append(grid[i][rc]);
            }
        }
        return sb.toString();
    }
}
public class EqualRowCol {
    public static void main(String[] args) {
        int[][] mat = new int[][]{{3,2,1},{1,7,6},{2,7,7}};
        SolutionERC erc = new SolutionERC();
        SolutionSERC serc = new SolutionSERC();
        int[][] t2 = new int[][]{{3,1,2,2},{1,4,4,5},{2,4,2,2},{2,4,2,2}};
        System.out.println(serc.equalPairs(mat));
        System.out.println(serc.equalPairs(t2));
    }
}
