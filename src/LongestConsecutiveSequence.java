import java.util.*;

class SolutionLCSHM {
    public int longestConsecutive(int[] nums) {
        int lSequence = Integer.MIN_VALUE;
        TreeSet<Integer> set = new TreeSet<>();
        for(int n : nums)set.add(n);

        int counter = 0;
        if(set.size() == 1) return 1;
        int prev = set.pollFirst();
       while (!set.isEmpty()){
          int curr = set.pollFirst();
          if(curr-prev == 1){
              counter++;
          }else{
              lSequence = Math.max(lSequence,counter);
              counter = 0;
          }
            lSequence = Math.max(lSequence,counter);
          prev = curr;
        }
        return lSequence+1;
    }
}
public class LongestConsecutiveSequence {
    public static void main(String[] args) {
        SolutionLCSHM lc = new SolutionLCSHM();
       /// System.out.println(lc.longestConsecutive(new int[]{100,4,200,1,3,2}));
       // System.out.println(lc.longestConsecutive(new int[]{0,3,7,2,5,8,4,6,0,1}));
        System.out.println(lc.longestConsecutive(new int[]{0,0}));
    }
}
