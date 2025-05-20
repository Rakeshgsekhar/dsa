import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

class SolutionLN {
    public String largestNumber(int[] nums) {
        StringBuilder res = new StringBuilder();
        String[] sorted = sort(nums);
        for(String s : sorted) res.append(s);
        while (res.charAt(0) == '0' && res.length() > 1) {
            res.deleteCharAt(0);
        }
        return res.toString();
    }
    private String[] sort(int[] nums){
        String[] sorted = new String[nums.length];
        Map<Integer,PriorityQueue<String>> bucket = new HashMap<>();
        for(int i=0;i<10;i++){
            bucket.put(i, new PriorityQueue<>((a,b)->
                (b+a).compareTo(a+b)
            ));
        }
        for(int num:nums){
            int key = getKey(num);
            bucket.get(key).add(String.valueOf(num));
        }
        int index = 0;
        for(int i = 9;i>=0;i--){
            PriorityQueue<String> pqst = bucket.get(i);
            while(!pqst.isEmpty()){
                sorted[index++]=pqst.poll();
            }
        }
        return sorted;
    }
    private int getKey(int num){
        String str =  String.valueOf(num);
        return str.charAt(0)-'0';
    }

}
public class LargestNumber {
    public static void main(String[] args) {
        SolutionLN ln = new SolutionLN();
        //System.out.println(ln.largestNumber(new int[]{10,2}));
        System.out.println(ln.largestNumber(new int[]{3,30,34,5,9}));//.equals("9534330"));
        System.out.println(ln.largestNumber(new int[]{111311,1113}).equals("1113111311"));
        System.out.println(ln.largestNumber(new int[]{0,0}).equals("0"));
    }
}
