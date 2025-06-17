import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class SolutionLASQ {
    public int longestSubsequence(int[] arr, int difference) {
        Map<Integer, Integer> dp = new HashMap<>();
        int max = 0;
        for (int num : arr) {
            int prev = num - difference;
            int len = dp.getOrDefault(prev, 0) + 1;
            dp.put(num, len);
            max = Math.max(max, len);
        }
        return max;
    }

    private int compute(int index,int diff,Map<Integer,Integer> memo){
        if(memo.containsKey(index)) return memo.get(index);
        int prevVal = index - diff;
        int len = 1+compute(prevVal,diff,memo);
        memo.put(index,len);
        return len;
    }
}
public class LongestArithematicSubsequence {
    public static void main(String[] args) {
        SolutionLASQ lasq = new SolutionLASQ();
        System.out.println(lasq.longestSubsequence(new int[]{1,5,7,8,5,3,4,2,1},-2));
        System.out.println(lasq.longestSubsequence(new int[]{1,2,3,4},1));
        System.out.println(lasq.longestSubsequence(new int[]{1,3,5,7},1));
        System.out.println(lasq.longestSubsequence(new int[]{24,55,-149,25,134,-63,-57,95,-124,141,-65,85,111,-119,179,180,-24,186,-126,-91,-69,-27,-77,-190,59,140,-103,-156,138,158,103,-10,-113,-67,8,80,-165,95,129,-148,17,106,23,-104,110,-42,33,166,94,171,23,35,60,-93,71,83,193,-65,153,181,-144,-168,178,44,48,139,-3,-61,172,32,-122,-150,175,97,183,200,187,-132,88,8,-109,-183,-150,-123,-151,-24,177,197,-108,-168,-170,-43,-143,108,-96,-135,137,-53,126,-20,140,-14,-200,-192,-25,177,-65,41,140,107,-76,187,-118,-15,-127,-170,-99,81,-96,125,157,177,-56,-118,-179,176,125,157,140,-92,-87,-14,158,-145,130,-41,-27,-6,-126,83,-137,144,85,134,-84,147,-168,-153,-179,163,-40,-122,-80,200,173,-27,21,199,105,64,97,-4,60,87,-152,-181,-21,-45,-196,26,-141,-3,4,-196,-100,171,77,92,-119,-174,35,-58,-198,-123,-87,-109,112,141,-128,79,-11,61,200,-155,-117,-129,25,-110,-176,-25},-8));
    }
}
