class SolutionCUP {
    public int countPermutations(int[] complexity) {
        int MOD = 1_000_000_007;
        int n = complexity.length;
        long[]dp = new long[n];
        if(complexity[1]<= complexity[0]) return 0;
        /*int min = complexity[0],minIndex = 0;
        for(int i = 1;i<n;i++){
            if(complexity[i]<min){
                min = complexity[i];
                minIndex = i;
            }
        }
        int minComplex = 1;

        for(int i = 0;i<n;i++){
            if(complexity[i] == min && i!=minIndex) minComplex++;
        }
        if(minComplex>1) return 0;
        if(complexity[0] != min) return 0;*/

        int unlocked = 2;
        dp[0] = 0;
        dp[1] = 1;
        for(int i = 2;i<n;i++){
            if(complexity[i]<=complexity[0]) return 0;
            else {
                dp[i] = unlocked * dp[i - 1] % MOD;
                unlocked = unlocked % MOD + 1;
            }
        }
//        if(unlocked!=n) return 0;
        return (int)dp[n-1];
    }
}
public class ComputerUnlockingPer {
    public static void main(String[] args) {
        SolutionCUP cup = new SolutionCUP();
        cup.countPermutations(new int[]{38,223,100,123,406,234,256,93,222,259,233,69,139,245,45,98,214});
    }
}
