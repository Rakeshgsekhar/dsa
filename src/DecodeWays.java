import java.util.Arrays;

class SolutionDW {
    public int numDecodings(String s) {
        int n = s.length();
        int[] dp = new int[n+1];
        Arrays.fill(dp,-1);
        return compute(0,s,dp);
    }
    private int compute(int i,String s, int[]dp){
        if(i == s.length()) return 1;
        if(s.charAt(i) == '0') return 0;
        if(dp[i] != -1) return dp[i];

        int count = compute(i+1,s,dp);
        if(i+1<s.length()){
            int num = Integer.parseInt(s.substring(i,i+2));
            if(num>=10 && num<=26){
                count+=compute(i+2,s,dp);
            }
        }
        return dp[i]=count;
    }
}
public class DecodeWays {
    public static void main(String[] args) {
        SolutionDW dw = new SolutionDW();
//        dw.numDecodings("12");
        System.out.println(dw.numDecodings("226"));
    }
}
