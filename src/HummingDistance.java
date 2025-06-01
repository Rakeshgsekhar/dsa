class SolutionHDD {
    public int hammingDistance(int x, int y) {
        int count = 0;
        int xor = x ^ y;
        int i =x,j = y;
        while(i!=j){
            i = i>>1;
            j= j >>1;
            count++;
            //System.out.println(String.format("%32s", Integer.toBinaryString(i)).replace(' ', '0'));
            //System.out.println(String.format("%32s", Integer.toBinaryString(j)).replace(' ', '0'));
        }
       System.out.println("cc: "+count);
        i = i<<count;
        return i;
    }
}
public class HummingDistance {
    public static void main(String[] args) {
        SolutionHDD hd = new SolutionHDD();
        hd.hammingDistance(5,7);
        //System.out.println();
        hd.hammingDistance(1,2147483647);
        hd.hammingDistance(2,25);
        hd.hammingDistance(14,28);
        hd.hammingDistance(43,60);
        hd.hammingDistance(25,35);
        hd.hammingDistance(4194304,134217709);
        hd.hammingDistance(536870913,1073741804);
        hd.hammingDistance(2097152,8388583);
        hd.hammingDistance(268435456,1073741822);
        /**
         * 2
         * 25
         * 14
         * 28
         * 43
         * 60
         * 25
         * 35
         * 4194304
         * 134217709
         * 536870913
         * 1073741804
         * 2097152
         * 8388583
         * 268435456
         * 1073741822
         */

    }
}
