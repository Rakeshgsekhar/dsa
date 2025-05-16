
class SolutionOLI {
    public int largestOverlap(int[][] img1, int[][] img2) {
        /*
        int n = img1.length;
        int result = 0;
        for(int row = -n;row<n;row++){
            for(int col = -n;col<n;col++){
                result = Math.max(result, countPairs(img1,img2,row,col));
            }
        }

        return result;
        */
        int count = 0;

        int n = img1.length;
        int[][] counter = new int[2*n+1][2*n+1];
        for(int r1 = 0;r1<n;r1++){
            for(int c1 = 0;c1<n;c1++){
                if(img1[r1][c1] == 0) continue;
                for(int r2=0;r2<n;r2++){
                    for(int c2=0;c2<n;c2++){
                        if(img2[r2][c2] == 1){
                            counter[r2-r1+n][c2-c1+n]++;
                            System.out.println("*********");
                            System.out.println("("+r1+","+c1+")");
                            System.out.println("("+r2+","+c2+")");
                            System.out.println((r2-r1+n)+":"+(c2-c1+n)+":"+"->"+counter[r2-r1+n][c2-c1+n]);
                        }
                    }
                }
            }
        }

        for(int [] cRows : counter){
            for(int cRow : cRows){
                count = count>cRow?count:cRow;
            }
        }

        return count;
    }
}
public class OverLapImage {
    public static void main(String[] args) {
        SolutionOLI oli = new SolutionOLI();
        int[][] img1 = new int[][]{{1,1,0},{0,1,0},{0,1,0}};
        int[][] img2 = new int[][]{{0,0,0},{0,1,1},{0,0,1}};
        System.out.println(oli.largestOverlap(img1,img2));
    }
}
