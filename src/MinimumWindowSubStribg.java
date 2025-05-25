import java.util.HashMap;

class SolutionMWS {
    public String minWindow(String s, String t) {
//        HashMap<Integer,Integer> map = new HashMap<>();
        int[] map = new int[128];
        for(char ch : t.toCharArray()){
            int key = ch-'0';
            map[key]++;
        }
        int tCount= t.length();
        StringBuilder res = new StringBuilder(s);


        int end = 0,begin = 0,len=Integer.MAX_VALUE,head=0;

        while(end<s.length()){
            int key = s.charAt(end++)-'0';
            if(map[key]-->0){tCount --;}
            while(tCount == 0){
                if(end-begin<len) len = end-(head=begin);
                int key2 = s.charAt(begin++);
                if(map[key]++ == 0) tCount++;
            }
        }
        return len == Integer.MAX_VALUE?"":res.substring(head,len);
    }
}
public class MinimumWindowSubStribg {
}
