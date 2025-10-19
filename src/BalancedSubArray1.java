import org.w3c.dom.ls.LSOutput;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class SolutionLBSI {
    public int longestBalanced(int[] nums) {
        int longest = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            Set<Integer> even = new HashSet<>();
            Set<Integer> odd = new HashSet<>();

            for (int j = i; j < n; j++) {
                int num = nums[j];
                if (num % 2 == 0) {
                    even.add(num);
                } else {
                    odd.add(num);
                }

                if (even.size() == odd.size()) {
                    longest = Math.max(longest, j - i + 1);
                }
            }
        }

        return longest;
    }
}
public class BalancedSubArray1 {
    public static void main(String[] args) {
        SolutionLBSI b = new SolutionLBSI();
        System.out.println(b.longestBalanced(new int[]{3,2,2,5,4}));
    }


}
