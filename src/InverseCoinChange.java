import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class SolutionIC {
    public List<Integer> findCoins(int[] numWays) {
        /*int n = numWays.length;
        List<Integer> result = new ArrayList<>();
        int [] dp = new int[n+1];
        dp[0] = 1;

        for(int coin = 1 ; coin <=n;coin++){
            int[] temp = Arrays.copyOf(dp,n+1);
            for(int i = coin;i<=n;i++){
                temp[i] += dp[i-coin];
            }
            boolean isDenominationNeeded = false;
            for(int i = 1;i<=n;i++){
                if(temp[i]>dp[i] && temp[i]<=numWays[i-1]){
                    isDenominationNeeded = true;
                    break;
                }
            }
            if(isDenominationNeeded){
                result.add(coin);
                for(int i = coin;i<=n;i++){
                    dp[i] += dp[i-coin];
                }
            }

            boolean isMatch = true;
            for(int i = 1;i<=n;i++){
                if(dp[i] != numWays[i-1]){
                    isMatch = false;
                    break;
                }
            }
            if(isMatch) return result;
        }
        for(int i = 1;i<=n;i++){
            if(dp[i] != numWays[i-1])return new ArrayList<>();
        }

        return result;*/
        int n = numWays.length;
        int[] dp = new int[n + 1];
        dp[0] = 1;

        List<Integer> coins = new ArrayList<>();

        for (int coin = 1; coin <= n; coin++) {
            int[] temp = Arrays.copyOf(dp, n + 1);
            for (int i = coin; i <= n; i++) {
                temp[i] += dp[i - coin];
            }

            // Check if this coin is actually needed
            boolean required = false;
            for (int i = 1; i <= coin; i++) {
                if (temp[i] > dp[i] && temp[i] <= numWays[i-1]) {
                    required = true;
                    break;
                }
            }

            if (!required) continue;

            coins.add(coin);
            for (int i = coin; i <= n; i++) {
                dp[i] += dp[i - coin];
            }
        }

        // Final validation
        for (int i = 1; i <= n; i++) {
            if (dp[i] != numWays[i - 1]) return new ArrayList<>();  // Invalid case
        }

        return coins;
    }

}
public class InverseCoinChange {
    public static void main(String[] args) {
        SolutionIC  ic = new SolutionIC();
        System.out.println(ic.findCoins(new int[]{0,1,0,2,0,3,0,4,0,5}));

        System.out.println(ic.findCoins(new int[]{1,2,2,3,4}));
    }


}
