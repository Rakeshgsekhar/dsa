import java.util.HashMap;
import java.util.Map;

class SolutionCNSN {
    public int nonSpecialCount(int l, int r) {
        boolean[] prime = seivePrime(1000000000);
        int nonSpecial = r-l+1;
        int special = 0;
        int lim = (int) Math.sqrt(1e9);
        for (int i = 2; i <= lim; i++) {
            if (prime[i]) {
                int square = i * i;
                if (square >= l && square <= r) {
                    special++;
                }
            }
        }
        return nonSpecial-special;
    }

    private boolean[] seivePrime(int m){
        int n = (int) Math.sqrt(m);
        boolean prime[] = new boolean[n + 1];
        Map<Double,Boolean> map = new HashMap<>();
        for (int i = 0; i <= n; i++)
            prime[i] = true;

        for (int p = 2; p * p <= n; p++) {
            if (prime[p] == true) {
                for (int i = p * p; i <= n; i += p)
                    prime[i] = false;
            }
        }
        return prime;
    }
}
public class CountOfNonSpecialNumber {
    public static void main(String[] args) {
        SolutionCNSN cnsn = new SolutionCNSN();
       // cnsn.nonSpecialCount(5,7);
        cnsn.nonSpecialCount(4,16);
    }
}
