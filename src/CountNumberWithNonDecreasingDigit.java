import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CountNumberWithNonDecreasingDigit {
    Map<String,String> memo = new HashMap<>();
    public int countNumbers(String l, String r, int b) {
        int left = Integer.parseInt(l);
        int right = Integer.parseInt(r);

        int n = right-left+1;

        List<String> range = new ArrayList<>();

        for(int i = left;i<=right;i++){
            range.add(convertToBase(i,b));
        }

        int count = 0;
        for(String s : range){
            if(sorted(s)) count++;
        }

        return count;
    }

    public String convertToBase(int val, int base){

        if(memo.keySet().contains(val+"/"+base)){
            return memo.get(val+"/"+base);
        }
        int q = val/base;
        int r = val%base;
        if(val == 0) {
            memo.put(q+"/"+base,String.valueOf(r));
            return String.valueOf(r);
        }
        else
            return convertToBase(q,base)+String.valueOf(r);

    }

    public boolean sorted(String s){
        int l = s.length();
        for(int i = 1;i<l;i++){
            int k = s.charAt(i) - '0';
            int h = s.charAt(i-1) - '0';
            if(k<h) return false;
        }
        return true;
    }
}
