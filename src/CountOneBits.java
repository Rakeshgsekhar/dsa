class SolutionCOB {
    public int hammingWeight(int n) {
        int count = 0;
        for(int i = 0;i<32;i++){
            if((n & (1<<i))!=0)count++;
        }
        return count;
    }
}
public class CountOneBits {
    public static void main(String[] args) {
        SolutionCOB cob = new SolutionCOB();
        System.out.println(cob.hammingWeight(2147483645));
    }
}
