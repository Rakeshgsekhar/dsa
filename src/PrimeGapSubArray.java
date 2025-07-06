import java.util.*;

class SolutionPrimGap {
    int count = 0;
    private static final int M = 50000;
    private static boolean[] p = new boolean[M + 1];
    private static boolean done = false;

    private void sieve() {
        if (!done) {
            Arrays.fill(p, true);
            p[0] = p[1] = false;
            for (int i = 2; i * i <= M; i++) {
                if (p[i]) {
                    for (int j = i * i; j <= M; j += i)
                        p[j] = false;
                }
            }
            done = true;
        }
    }
    public int primeSubarray(int[] nums, int k) {
        sieve();
        int n = nums.length;
        long ans = 0;

        int[] f = new int[n];
        for (int i = 0; i < n; i++) f[i] = p[nums[i]] ? 1 : 0;

        LinkedList<Integer> minQ = new LinkedList<>();
        LinkedList<Integer> maxQ = new LinkedList<>();
        LinkedList<Integer> primes = new LinkedList<>();

        int l = 0;

        for (int r = 0; r < n; r++) {
            if (f[r] == 1) {
                while (!minQ.isEmpty() && nums[minQ.peekLast()] >= nums[r]) minQ.pollLast();
                minQ.addLast(r);

                while (!maxQ.isEmpty() && nums[maxQ.peekLast()] <= nums[r]) maxQ.pollLast();
                maxQ.addLast(r);

                primes.addLast(r);
            }

            while (!minQ.isEmpty() && !maxQ.isEmpty()) {
                int minV = nums[minQ.peekFirst()];
                int maxV = nums[maxQ.peekFirst()];

                if (maxV - minV > k) {
                    if (minQ.peekFirst() == l) minQ.pollFirst();
                    if (maxQ.peekFirst() == l) maxQ.pollFirst();
                    if (!primes.isEmpty() && primes.peekFirst() == l) primes.pollFirst();
                    l++;
                } else break;
            }

            if (primes.size() >= 2) {
                int x = primes.get(primes.size() - 2);
                ans += (x - l + 1);
            }
        }

        return (int) ans;
    }

}
public class PrimeGapSubArray {
    public static void main(String[] args) {
        SolutionPrimGap pgap = new SolutionPrimGap();
        int count = pgap.primeSubarray(new int[]{139,26863,4817},24583);
        System.out.println(count);
    }
}
