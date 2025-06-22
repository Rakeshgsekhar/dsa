import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class SolutionPF {
    List<Integer> list = new ArrayList<>(Arrays.asList(2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97));
    public boolean checkPrimeFrequency(int[] nums) {
       int[] dp = new int[101];
       for(int i : nums){
           dp[i]++;
       }
       for(int i = 0;i<dp.length;i++){
           if(list.contains(dp[i])) return true;
       }
       return false;
    }
}
public class PrimeFreq {
    public static void main(String[] args) {
        SolutionPF pf = new SolutionPF();
        System.out.println(pf.checkPrimeFrequency(new int[]{2,2}));
    }
}
