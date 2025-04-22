import java.util.HashMap;
import java.util.Map;

public class EqualPairs {
    public int equalPairs(int[][] grid) {
        int n = grid.length;
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

        return counter;
    }

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

    /*

    public int equalPairs(int[][] grid) {
        int n = grid.length;
        String[] rows = new String[n];
        String[] cols = new String[n];
        Map<String,Integer> mapper = new HashMap<>();
        int counter = 0;
        for(int i = 0;i<n;i++){
            String s = "";
            for(int j = 0;j<n;j++){
                s+=grid[i][j];
                s+="-";
            }
            mapper.put(s,mapper.getOrDefault(s,0)+1);
        }

        for(int i = 0;i<n;i++){
            String s = "";
            for(int j = 0;j<n;j++){
                s+=grid[j][i];
                s+="-";
            }
            counter+=mapper.getOrDefault(s,0);
        }

        return counter;
    }


    3rd
     public int equalPairs(int[][] grid) {
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
    }
     */

}
