import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class SolutionNUP {
    int count;
    boolean reached = false;
    public int minMoves(String[] matrix) {
       Map<String, List<String>> map;
       map = buildMap(matrix);
       count = 0;

        System.out.println(map);
       int cc = minMoves(0,0,matrix.length,matrix[0].length(),matrix,map);
        System.out.println(cc);
       return reached?count:-1;
    }

    private Map<String, List<String>> buildMap(String[] matrix){
        Map<String, List<String>> map = new HashMap<>();
        String s = "ABCDEFGHIJKLMNOPQRSTUVWXZY";
        for(char c : s.toCharArray()){
            map.put(String.valueOf(c),new ArrayList<>());
        }
        for(int i =0;i<matrix.length;i++){
            for(int j = 0;j<matrix[0].length();j++){
                if(Character.isAlphabetic(matrix[i].charAt(j))){
                    String rc = i+""+j;
                    map.get(String.valueOf(matrix[i].charAt(j))).add(rc);
                }
            }
        }
        return map;
    }

    int  minMoves(int r,int c,int row,int col,String[]matrix,Map<String, List<String>> map){
        if(r>row-1 || c> col-1 || r<0 || c<0 || matrix[r].charAt(c) == '#') return Integer.MAX_VALUE;
        if(r==row-1 && c == col-1) {
            reached = true;
            return count;
        }
        if(Character.isAlphabetic(matrix[r].charAt(c))){
            int size = map.get(String.valueOf(matrix[r].charAt(c))).size();
            String rc = map.get(String.valueOf(matrix[r].charAt(c))).get(size-1);
            r = rc.charAt(0)-'0';
            c = rc.charAt(1)-'0';
            count--;
        }
        StringBuilder str = new StringBuilder(matrix[r]);
        str.setCharAt(c,'#');
        matrix[r] = str.toString();
        count++;
        int l = minMoves(r+1,c,row,col,matrix,map);
        int ri = minMoves(r,c+1,row,col,matrix,map);
        int dn = minMoves(r-1,c,row,col,matrix,map);
        int up = minMoves(r,c-1,row,col,matrix,map);
        return Math.min(l,Math.min(ri,Math.min(dn,up)));
    }
}
public class NumberOfPath {
    public static void main(String[] args) {
        SolutionNUP nup = new SolutionNUP();
        System.out.println(nup.minMoves(new String[]{"A..",".A.","..."}));
        System.out.println(nup.minMoves(new String[]{".#...",".#.#.",".#.#.","...#."}));
    }
}
