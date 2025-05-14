import java.util.Arrays;

class SolutionZZ {
    public String convert(String s, int numRows) {
        int n  = s.length();
        char[][] mat = new char[numRows][n];
        for(int i = 0;i<numRows;i++){
            Arrays.fill(mat[i],'*');
        }

        int index = 0;
        int row = 0;
        int col = 0;
        while(index<n){
            if(row == 0){
                while(row<numRows && index<n){
                    mat[row++][col] = s.charAt(index++);
                }
                row--;
            }else if(row == numRows-1){
                col++;
                row--;
                while(row>0 && index<n){
                    mat[row--][col++] = s.charAt(index++);
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0;i<numRows;i++){
            for(int j = 0;j<n;j++){
                if(mat[i][j] != '*')
                    sb.append(mat[i][j]);

                if(sb.length() == n) break;
                //System.out.print(mat[i][j]);
            }
           // System.out.println();
        }
        return sb.toString();
    }
}
public class ZigZag {

    public static void main(String[] args) {
        SolutionZZ zz = new SolutionZZ();
        System.out.println(zz.convert("PAYPALISHIRING",3).equals("PAHNAPLSIIGYIR"));
        System.out.println(zz.convert("PAYPALISHIRING",4).equals("PINALSIGYAHRPI"));
//        System.out.println(zz.convert("PAYPALISHIRING",3).equals("PAHNAPLSIIGYIR"));


    }
}
